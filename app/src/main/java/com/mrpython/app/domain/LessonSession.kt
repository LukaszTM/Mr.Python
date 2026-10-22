package com.mrpython.app.domain

import kotlin.random.Random

/**
 * Progress through one lesson. Like in Duolingo, an exercise answered
 * wrongly goes to the back of the queue and must be solved again.
 */
data class LessonSession(
    val lessonId: String,
    val queue: List<Exercise>,
    val total: Int,
    val solved: Int = 0,
    val mistakes: Int = 0,
) {
    val current: Exercise? get() = queue.firstOrNull()
    val isFinished: Boolean get() = queue.isEmpty()
    val progress: Float get() = if (total == 0) 1f else solved.toFloat() / total

    fun afterAnswer(correct: Boolean): LessonSession {
        val head = current ?: return this
        return if (correct) {
            copy(queue = queue.drop(1), solved = solved + 1)
        } else {
            copy(queue = queue.drop(1) + head, mistakes = mistakes + 1)
        }
    }

    companion object {
        /** How many exercises a replay draws from the lesson's pool. */
        const val REPLAY_SIZE = 10

        /**
         * A first attempt goes through the core exercises in order. A replay draws
         * [REPLAY_SIZE] random exercises from the whole pool, so it differs every time.
         * Introductions are always read in order.
         */
        fun start(lesson: Lesson, replay: Boolean = false, random: Random = Random.Default): LessonSession {
            val queue = if (replay && !lesson.isIntro) lesson.pool.shuffled(random).take(REPLAY_SIZE) else lesson.exercises
            return LessonSession(lessonId = lesson.id, queue = queue, total = queue.size)
        }
    }
}
