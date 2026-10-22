package com.mrpython.app.domain

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
        fun start(lesson: Lesson) = LessonSession(
            lessonId = lesson.id,
            queue = lesson.exercises,
            total = lesson.exercises.size,
        )
    }
}
