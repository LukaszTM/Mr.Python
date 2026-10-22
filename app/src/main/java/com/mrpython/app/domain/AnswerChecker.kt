package com.mrpython.app.domain

object AnswerChecker {

    fun isCorrect(exercise: Exercise, answer: Answer): Boolean = when (exercise) {
        is MultipleChoice -> answer is Answer.Choice && answer.index == exercise.correctIndex
        is FillInBlank -> answer is Answer.Choice &&
            exercise.options.getOrNull(answer.index) == exercise.correct
        is ArrangeTiles -> answer is Answer.Tiles &&
            (listOf(exercise.solution) + exercise.alternatives).any { it == answer.tiles }
        is PredictOutput -> answer is Answer.Text &&
            exercise.accepted.any { normalizeOutput(it) == normalizeOutput(answer.value) }
    }

    /** The answer shown to the learner after a mistake. */
    fun correctAnswerText(exercise: Exercise): String = when (exercise) {
        is MultipleChoice -> exercise.options[exercise.correctIndex]
        is FillInBlank -> exercise.correct
        is ArrangeTiles -> exercise.solution.joinToString(" ")
        is PredictOutput -> exercise.accepted.first()
    }

    /**
     * Program output is compared line by line, ignoring surrounding whitespace,
     * blank lines at the edges and the line separator style. Case matters
     * (Python prints `True`, not `true`).
     */
    fun normalizeOutput(text: String): String =
        text.replace("\r\n", "\n")
            .lines()
            .map { it.trim() }
            .dropWhile { it.isEmpty() }
            .dropLastWhile { it.isEmpty() }
            .joinToString("\n")
}
