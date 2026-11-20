package com.mrpython.app.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mrpython.app.data.CourseContent
import com.mrpython.app.data.ProgressRepository
import com.mrpython.app.data.SettingsRepository
import com.mrpython.app.domain.Answer
import com.mrpython.app.domain.AnswerChecker
import com.mrpython.app.domain.Avatar
import com.mrpython.app.domain.Avatars
import com.mrpython.app.domain.Events
import com.mrpython.app.domain.Explanation
import com.mrpython.app.domain.LessonSession
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.Rules
import com.mrpython.app.domain.XpEvent
import com.mrpython.app.notifications.ReminderScheduler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

enum class Tab { LEARN, LEAGUE, PROFILE }

data class Feedback(
    val correct: Boolean,
    val correctAnswer: String,
    val explanation: String,
    /** The first mistake in an exercise: the learner may fix the answer at no cost. */
    val retry: Boolean = false,
    /** Accepted although mistyped: the panel also shows how the answer is spelled exactly. */
    val typo: Boolean = false,
)

data class ActiveLesson(
    val session: LessonSession,
    /** Practice = replaying a finished lesson: no hearts lost, one heart gained. */
    val isPractice: Boolean,
    val feedback: Feedback? = null,
    /** The free correction for the current exercise has been used up. */
    val retryUsed: Boolean = false,
)

data class LessonResult(
    val xpEarned: Int,
    val accuracyPercent: Int,
    val streak: Int,
    val isPractice: Boolean,
    /** A replay gave a heart back (only when hearts weren't already full). */
    val heartRestored: Boolean = false,
    /** The XP event that multiplied this lesson's XP, if one was running. */
    val event: XpEvent? = null,
)

data class AppUiState(
    val progress: Progress,
    val nowMillis: Long,
    val today: LocalDate,
    val tab: Tab = Tab.LEARN,
    val lesson: ActiveLesson? = null,
    val result: LessonResult? = null,
    val outOfHearts: Boolean = false,
    val remindersEnabled: Boolean = true,
    val reminderHour: Int = 19,
) {
    val now: LocalDateTime
        get() = LocalDateTime.ofInstant(Instant.ofEpochMilli(nowMillis), ZoneId.systemDefault())

    /** The XP event running right now, if any. */
    val event: XpEvent? get() = Events.active(now)
}

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProgressRepository(application)
    private val settings = SettingsRepository(application)

    private val _state = MutableStateFlow(
        AppUiState(
            progress = Rules.rolloverLeague(
                Rules.refillHearts(repository.load(), System.currentTimeMillis()),
                LocalDate.now(),
            ),
            nowMillis = System.currentTimeMillis(),
            today = LocalDate.now(),
            remindersEnabled = settings.remindersEnabled,
            reminderHour = settings.reminderHour,
        )
    )
    val state: StateFlow<AppUiState> = _state.asStateFlow()

    init {
        persist()
        ReminderScheduler.schedule(application)
        // Keeps the heart timer, streak and league week up to date while the app is open.
        viewModelScope.launch {
            while (true) {
                delay(1_000)
                val now = System.currentTimeMillis()
                val today = LocalDate.now()
                val before = _state.value.progress
                _state.update {
                    it.copy(
                        progress = Rules.rolloverLeague(Rules.refillHearts(it.progress, now), today),
                        nowMillis = now,
                        today = today,
                    )
                }
                if (_state.value.progress.leagueWeekStartEpochDay != before.leagueWeekStartEpochDay) persist()
            }
        }
    }

    fun selectTab(tab: Tab) = _state.update { it.copy(tab = tab) }

    fun startLesson(lessonId: String) {
        val lesson = CourseContent.findLesson(lessonId) ?: return
        val s = _state.value
        if (!Rules.isUnlocked(CourseContent.units, lessonId, s.progress.completedLessons)) return
        val isPractice = lessonId in s.progress.completedLessons
        if (!isPractice && s.progress.hearts <= 0) {
            _state.update { it.copy(outOfHearts = true) }
            return
        }
        _state.update {
            it.copy(lesson = ActiveLesson(LessonSession.start(lesson, replay = isPractice), isPractice), result = null)
        }
    }

    fun submit(answer: Answer) {
        val active = _state.value.lesson ?: return
        if (active.feedback != null) return
        val exercise = active.session.current ?: return
        if (exercise is Explanation) {
            // Theory cards have no right or wrong answer: just move on.
            advance(active, active.session.afterAnswer(correct = true))
            return
        }
        // A slip of the finger or of the phone's dictionary still counts as a correct answer.
        val typo = AnswerChecker.isTypo(exercise, answer)
        val correct = typo || AnswerChecker.isCorrect(exercise, answer)
        if (!correct && !active.retryUsed) {
            // Every exercise forgives one mistake: no heart lost, the answer stays hidden.
            val retry = Feedback(false, "", "", retry = true)
            _state.update { it.copy(lesson = active.copy(feedback = retry, retryUsed = true)) }
            return
        }
        val feedback = Feedback(correct, AnswerChecker.correctAnswerText(exercise), exercise.explanation, typo = typo)
        _state.update {
            val progress = if (!correct && !active.isPractice) {
                Rules.loseHeart(it.progress, System.currentTimeMillis())
            } else {
                it.progress
            }
            it.copy(progress = progress, lesson = active.copy(feedback = feedback))
        }
        persist()
    }

    fun continueLesson() {
        val s = _state.value
        val active = s.lesson ?: return
        val feedback = active.feedback ?: return
        if (feedback.retry) {
            _state.update { it.copy(lesson = active.copy(feedback = null)) }
            return
        }
        advance(active, active.session.afterAnswer(feedback.correct))
    }

    private fun advance(active: ActiveLesson, session: LessonSession) {
        when {
            !active.isPractice && _state.value.progress.hearts <= 0 -> _state.update {
                it.copy(lesson = null, outOfHearts = true)
            }
            session.isFinished -> finishLesson(session, active.isPractice)
            else -> _state.update { it.copy(lesson = active.copy(session = session, feedback = null, retryUsed = false)) }
        }
    }

    private fun finishLesson(session: LessonSession, isPractice: Boolean) {
        val event = Events.active(LocalDateTime.now())
        _state.update {
            val today = LocalDate.now()
            val progress = Rules.completeLesson(
                it.progress, session.lessonId, session.mistakes, today, event?.multiplier ?: 1,
            )
            val attempts = session.total + session.mistakes
            it.copy(
                progress = progress,
                lesson = null,
                result = LessonResult(
                    xpEarned = progress.totalXp - it.progress.totalXp,
                    accuracyPercent = if (attempts == 0) 100 else session.total * 100 / attempts,
                    streak = progress.streak,
                    isPractice = isPractice,
                    heartRestored = progress.hearts > it.progress.hearts,
                    event = event,
                ),
            )
        }
        persist()
        // Today's lesson is done, so a reminder still on screen is no longer needed.
        ReminderScheduler.clearShown(getApplication<Application>())
    }

    fun quitLesson() = _state.update { it.copy(lesson = null) }

    fun dismissResult() = _state.update { it.copy(result = null) }

    fun dismissOutOfHearts() = _state.update { it.copy(outOfHearts = false) }

    fun dismissWeekResult() {
        _state.update { it.copy(progress = it.progress.copy(pendingWeekResult = null)) }
        persist()
    }

    /** Changes the avatar; parts not unlocked at the current league tier are ignored. */
    fun setAvatar(avatar: Avatar) {
        if (!Avatars.isAllowed(avatar, _state.value.progress.leagueTier)) return
        _state.update { it.copy(progress = it.progress.copy(avatar = avatar)) }
        persist()
    }

    fun setRemindersEnabled(enabled: Boolean) {
        settings.remindersEnabled = enabled
        _state.update { it.copy(remindersEnabled = enabled) }
        ReminderScheduler.schedule(getApplication<Application>())
    }

    fun setReminderHour(hour: Int) {
        settings.reminderHour = hour
        _state.update { it.copy(reminderHour = hour) }
        ReminderScheduler.schedule(getApplication<Application>())
    }

    /**
     * True once, after the first finished lesson: the moment to show the system
     * notification permission dialog (needed on Android 13+).
     */
    fun shouldAskForNotificationPermission(): Boolean {
        if (settings.notificationPermissionAsked || !settings.remindersEnabled) return false
        settings.notificationPermissionAsked = true
        return !ReminderScheduler.canNotify(getApplication<Application>())
    }

    fun resetProgress() {
        repository.reset()
        _state.update { it.copy(progress = Progress(), lesson = null, result = null) }
        persist()
    }

    private fun persist() = repository.save(_state.value.progress)
}
