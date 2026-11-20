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
        is Explanation -> true
    }

    /** The answer shown to the learner after a mistake. */
    fun correctAnswerText(exercise: Exercise): String = when (exercise) {
        is MultipleChoice -> exercise.options[exercise.correctIndex]
        is FillInBlank -> exercise.correct
        is ArrangeTiles -> exercise.solution.joinToString(" ")
        is PredictOutput -> exercise.accepted.first()
        is Explanation -> ""
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

    /**
     * True when a typed answer misses only by what a phone keyboard does on its own or by a
     * slip of the finger: typographic quotes and dashes, a first letter capitalised by the
     * keyboard, or one wrong letter (or two swapped ones) in a longer line. Such answers are
     * accepted with a remark. Anything a lesson may be testing still has to match: digits,
     * spaces, the length of each line and the case of every other letter.
     */
    fun isTypo(exercise: Exercise, answer: Answer): Boolean {
        if (exercise !is PredictOutput || answer !is Answer.Text || isCorrect(exercise, answer)) return false
        val typed = loosen(answer.value).lines()
        return exercise.accepted.any { accepted ->
            val expected = loosen(accepted).lines()
            expected.size == typed.size && expected.zip(typed).all { (x, y) -> nearlySame(x, y) }
        }
    }

    /** Undoes the characters keyboards swap in by themselves. */
    private fun loosen(text: String): String =
        normalizeOutput(
            text.replace('\u00A0', ' ')
                .replace(Regex("[\u2018\u2019\u201A\u00B4]"), "'")
                .replace(Regex("[\u201C\u201D\u201E\u00AB\u00BB]"), "\"")
                .replace(Regex("[\u2013\u2014\u2212]"), "-")
                .replace("\u2026", "...")
        )

    private fun nearlySame(expected: String, typed: String): Boolean {
        if (expected == typed) return true
        if (expected.length != typed.length) return false
        // The keyboard capitalises the first letter of a line by itself.
        val fixed = if (typed.first().isUpperCase() && expected.first() == typed.first().lowercaseChar()) {
            expected.first() + typed.drop(1)
        } else {
            typed
        }
        if (fixed == expected) return true
        if (expected.count { it.isLetter() } < MIN_LETTERS_FOR_TYPO) return false
        val diff = expected.indices.filter { expected[it] != fixed[it] }
        return when (diff.size) {
            // One wrong letter of the same case (never a digit, space or punctuation mark).
            1 -> diff[0].let { i ->
                expected[i].isLetter() && fixed[i].isLetter() && expected[i].isUpperCase() == fixed[i].isUpperCase()
            }
            // Two neighbouring letters swapped.
            2 -> diff[1] == diff[0] + 1 && expected[diff[0]] == fixed[diff[1]] && expected[diff[1]] == fixed[diff[0]] &&
                expected[diff[0]].isLetter() && expected[diff[1]].isLetter()
            else -> false
        }
    }

    private const val MIN_LETTERS_FOR_TYPO = 5
}
