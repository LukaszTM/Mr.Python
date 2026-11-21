package com.mrpython.app.ui

import android.app.Activity
import android.app.Application
import android.content.pm.ApplicationInfo
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mrpython.app.billing.BillingManager
import com.mrpython.app.data.CourseContent
import com.mrpython.app.data.ProgressRepository
import com.mrpython.app.data.SettingsRepository
import com.mrpython.app.domain.Answer
import com.mrpython.app.domain.AnswerChecker
import com.mrpython.app.domain.Avatar
import com.mrpython.app.domain.Avatars
import com.mrpython.app.domain.Boost
import com.mrpython.app.domain.Events
import com.mrpython.app.domain.Explanation
import com.mrpython.app.domain.Language
import com.mrpython.app.domain.LessonSession
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.Rules
import com.mrpython.app.domain.XpEvent
import com.mrpython.app.domain.t
import com.mrpython.app.notifications.ReminderScheduler
import com.mrpython.app.widget.StreakWidget
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
    /** The XP bonus that multiplied this lesson's XP, if one was running. */
    val event: XpEvent? = null,
    /** A bonus this lesson has just earned (a streak milestone); it applies to the next lessons. */
    val earned: XpEvent? = null,
    /** The bonus held before [earned]; it comes back if the learner takes hearts instead. */
    val boostBefore: Boost? = null,
    /** The learner swapped the earned XP bonus for full hearts. */
    val heartsTaken: Boolean = false,
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
    /** The one-time purchase that opens every module after the free ones. */
    val fullCourse: Boolean = false,
    /** Localized price from Google Play, once it is known. */
    val fullCoursePrice: String? = null,
    val heartsPrice: String? = null,
    val paywall: Boolean = false,
    /** Why the paywall opened, when a limit of the free version was hit. */
    val paywallReason: String? = null,
    val purchaseMessage: String? = null,
    /** Debug build: the purchase is simulated, no money is involved. */
    val testBuild: Boolean = false,
    val language: Language = Language.PL,
) {
    val now: LocalDateTime
        get() = LocalDateTime.ofInstant(Instant.ofEpochMilli(nowMillis), ZoneId.systemDefault())

    /** The XP bonus running right now, if any. */
    val event: XpEvent?
        get() = Events.active(progress, nowMillis)?.takeIf { fullCourse || Events.isWelcome(progress.boost) }
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
            fullCourse = settings.fullCourse,
            language = settings.language,
            testBuild = application.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0,
        )
    )
    val state: StateFlow<AppUiState> = _state.asStateFlow()

    private val testBuild get() = _state.value.testBuild

    private val billing = BillingManager(
        application,
        // A test build has no real purchase, so Google Play's "not owned" must not undo the simulated one.
        onOwned = { owned -> if (owned || !testBuild) setFullCourse(owned) },
        onHearts = ::grantHearts,
        onPrice = { product, price ->
            _state.update {
                if (product == BillingManager.HEARTS_REFILL) it.copy(heartsPrice = price) else it.copy(fullCoursePrice = price)
            }
        },
        onMessage = { message -> _state.update { it.copy(purchaseMessage = message) } },
    )

    init {
        if (!settings.welcomeBoostGiven) {
            settings.welcomeBoostGiven = true
            _state.update { it.copy(progress = it.progress.copy(boost = Events.welcome(System.currentTimeMillis()))) }
        }
        persist()
        ReminderScheduler.schedule(application)
        billing.refresh()
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
        // The full course also lifts the hearts limit.
        if (!isPractice && !s.fullCourse && s.progress.hearts <= 0) {
            billing.refresh()
            _state.update { it.copy(outOfHearts = true, purchaseMessage = null) }
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
            val progress = if (!correct && !active.isPractice && !it.fullCourse) {
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
            !active.isPractice && !_state.value.fullCourse && _state.value.progress.hearts <= 0 -> _state.update {
                it.copy(lesson = null, outOfHearts = true)
            }
            session.isFinished -> finishLesson(session, active.isPractice)
            else -> _state.update { it.copy(lesson = active.copy(session = session, feedback = null, retryUsed = false)) }
        }
    }

    private fun finishLesson(session: LessonSession, isPractice: Boolean) {
        val nowMillis = System.currentTimeMillis()
        _state.update {
            val today = LocalDate.now()
            val event = Events.active(it.progress, nowMillis)
                ?.takeIf { _ -> it.fullCourse || Events.isWelcome(it.progress.boost) }
            val finished = Rules.completeLesson(
                it.progress, session.lessonId, session.mistakes, today, event?.percent ?: 100, nowMillis,
            )
            // A streak milestone pays XP bonuses in the full version and full hearts in the free one.
            val milestone = finished.boost != it.progress.boost
            val progress = if (milestone && !it.fullCourse) {
                Rules.fillHearts(finished.copy(boost = it.progress.boost))
            } else {
                finished
            }
            val attempts = session.total + session.mistakes
            it.copy(
                progress = progress,
                lesson = null,
                result = LessonResult(
                    xpEarned = progress.totalXp - it.progress.totalXp,
                    accuracyPercent = if (attempts == 0) 100 else session.total * 100 / attempts,
                    streak = progress.streak,
                    isPractice = isPractice,
                    heartRestored = !(milestone && !it.fullCourse) && progress.hearts > it.progress.hearts,
                    event = event,
                    earned = if (milestone && it.fullCourse) Events.active(progress, nowMillis) else null,
                    heartsTaken = milestone && !it.fullCourse,
                    boostBefore = it.progress.boost,
                ),
            )
        }
        persist()
        // Today's lesson is done, so a reminder still on screen is no longer needed.
        ReminderScheduler.clearShown(getApplication<Application>())
    }

    fun quitLesson() = _state.update { it.copy(lesson = null) }

    fun dismissResult() = _state.update { it.copy(result = null) }

    fun dismissOutOfHearts() = _state.update { it.copy(outOfHearts = false, purchaseMessage = null) }

    fun dismissWeekResult() {
        _state.update { it.copy(progress = it.progress.copy(pendingWeekResult = null)) }
        persist()
    }

    fun showPaywall() = showPaywall(null)

    /** Accessories belong to the full version; the snake's colour is free. */
    fun showAvatarPaywall() = showPaywall("Akcesoria dla węża są dostępne w pełnej wersji.".t())

    private fun showPaywall(reason: String?) {
        billing.refresh()
        _state.update { it.copy(paywall = true, paywallReason = reason, purchaseMessage = null) }
    }

    fun dismissPaywall() = _state.update { it.copy(paywall = false, paywallReason = null, purchaseMessage = null) }

    /** Opens the Google Play purchase sheet for the full course. */
    fun buyFullCourse(activity: Activity) {
        if (billing.buy(activity, BillingManager.FULL_COURSE)) return
        if (testBuild) {
            setFullCourse(true)
        } else {
            _state.update {
                it.copy(purchaseMessage = "Sklep Google Play jest teraz niedostępny. Sprawdź połączenie z internetem i spróbuj ponownie.".t())
            }
        }
    }

    /** Opens the Google Play purchase sheet for a full hearts refill. */
    fun buyHearts(activity: Activity) {
        if (billing.buy(activity, BillingManager.HEARTS_REFILL)) return
        if (testBuild) {
            grantHearts()
        } else {
            _state.update {
                it.copy(purchaseMessage = "Sklep Google Play jest teraz niedostępny. Sprawdź połączenie z internetem i spróbuj ponownie.".t())
            }
        }
    }

    private fun grantHearts() {
        _state.update { it.copy(progress = Rules.fillHearts(it.progress), outOfHearts = false, purchaseMessage = null) }
        persist()
    }

    /** On the result screen: give up the XP bonus just earned and take full hearts instead. */
    fun takeHeartsInsteadOfBonus() {
        val result = _state.value.result ?: return
        if (result.earned == null) return
        _state.update {
            it.copy(
                progress = Rules.fillHearts(it.progress.copy(boost = result.boostBefore)),
                result = result.copy(earned = null, heartsTaken = true),
            )
        }
        persist()
    }

    /** Asks Google Play again what the account owns (after a reinstall or on a new phone). */
    fun restorePurchase() {
        billing.refresh()
        _state.update { it.copy(purchaseMessage = "Sprawdzam zakupy na Twoim koncie Google…".t()) }
    }

    private fun setFullCourse(owned: Boolean) {
        settings.fullCourse = owned
        _state.update {
            it.copy(fullCourse = owned, paywall = it.paywall && !owned, purchaseMessage = if (owned) null else it.purchaseMessage)
        }
    }

    /** Changes the avatar; parts not unlocked at the current league tier are ignored. */
    fun setAvatar(avatar: Avatar) {
        val s = _state.value
        // The free version may change the snake but not dress it up (taking things off is fine).
        val added = avatar.accessories - s.progress.avatar.accessories.toSet()
        if (!s.fullCourse && added.isNotEmpty()) {
            showAvatarPaywall()
            return
        }
        if (!Avatars.isAllowed(avatar, s.progress.leagueTier)) return
        _state.update { it.copy(progress = it.progress.copy(avatar = avatar)) }
        persist()
    }

    /** Switches the language of the app and of the course; progress is shared between languages. */
    fun setLanguage(language: Language) {
        settings.language = language
        _state.update { it.copy(language = language, lesson = null, result = null) }
        StreakWidget.refresh(getApplication<Application>())
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
        if (testBuild) setFullCourse(false)
        _state.update { it.copy(progress = Progress(), lesson = null, result = null) }
        persist()
    }

    private fun persist() {
        repository.save(_state.value.progress)
        // The home screen widget shows the streak and the avatar, so it follows every change.
        StreakWidget.refresh(getApplication<Application>())
    }
}
