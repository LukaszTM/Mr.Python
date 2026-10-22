package com.mrpython.app.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mrpython.app.data.CourseContent
import com.mrpython.app.data.ProgressRepository
import com.mrpython.app.domain.Answer
import com.mrpython.app.domain.AnswerChecker
import com.mrpython.app.domain.LessonSession
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.Rules
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

enum class Tab { LEARN, LEAGUE, PROFILE }

data class Feedback(
    val correct: Boolean,
    val correctAnswer: String,
    val explanation: String,
)

data class ActiveLesson(
    val session: LessonSession,
    /** Practice = replaying a finished lesson: no hearts lost, one heart gained. */
    val isPractice: Boolean,
    val feedback: Feedback? = null,
)

data class LessonResult(
    val xpEarned: Int,
    val accuracyPercent: Int,
    val streak: Int,
    val isPractice: Boolean,
)

data class AppUiState(
    val progress: Progress,
    val nowMillis: Long,
    val today: LocalDate,
    val tab: Tab = Tab.LEARN,
    val lesson: ActiveLesson? = null,
    val result: LessonResult? = null,
    val outOfHearts: Boolean = false,
)

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProgressRepository(application)

    private val _state = MutableStateFlow(
        AppUiState(
            progress = Rules.rolloverLeague(
                Rules.refillHearts(repository.load(), System.currentTimeMillis()),
                LocalDate.now(),
            ),
            nowMillis = System.currentTimeMillis(),
            today = LocalDate.now(),
        )
    )
    val state: StateFlow<AppUiState> = _state.asStateFlow()

    init {
        persist()
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
        val correct = AnswerChecker.isCorrect(exercise, answer)
        val feedback = Feedback(correct, AnswerChecker.correctAnswerText(exercise), exercise.explanation)
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
        val session = active.session.afterAnswer(feedback.correct)

        when {
            !active.isPractice && s.progress.hearts <= 0 -> _state.update {
                it.copy(lesson = null, outOfHearts = true)
            }
            session.isFinished -> finishLesson(session, active.isPractice)
            else -> _state.update { it.copy(lesson = active.copy(session = session, feedback = null)) }
        }
    }

    private fun finishLesson(session: LessonSession, isPractice: Boolean) {
        _state.update {
            val today = LocalDate.now()
            val progress = Rules.completeLesson(it.progress, session.lessonId, session.mistakes, today)
            val attempts = session.total + session.mistakes
            it.copy(
                progress = progress,
                lesson = null,
                result = LessonResult(
                    xpEarned = progress.totalXp - it.progress.totalXp,
                    accuracyPercent = if (attempts == 0) 100 else session.total * 100 / attempts,
                    streak = progress.streak,
                    isPractice = isPractice,
                ),
            )
        }
        persist()
    }

    fun quitLesson() = _state.update { it.copy(lesson = null) }

    fun dismissResult() = _state.update { it.copy(result = null) }

    fun dismissOutOfHearts() = _state.update { it.copy(outOfHearts = false) }

    fun dismissWeekResult() {
        _state.update { it.copy(progress = it.progress.copy(pendingWeekResult = null)) }
        persist()
    }

    fun resetProgress() {
        repository.reset()
        _state.update { it.copy(progress = Progress(), lesson = null, result = null) }
    }

    private fun persist() = repository.save(_state.value.progress)
}
