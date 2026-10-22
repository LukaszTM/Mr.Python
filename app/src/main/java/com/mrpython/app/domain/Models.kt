package com.mrpython.app.domain

/** A single task shown to the learner inside a lesson. */
sealed interface Exercise {
    val id: String
    val instruction: String
    val explanation: String
}

/** Pick one answer out of several. [code] is optional context shown above the options. */
data class MultipleChoice(
    override val id: String,
    override val instruction: String,
    val code: String? = null,
    val options: List<String>,
    val correctIndex: Int,
    override val explanation: String,
) : Exercise

/** Code with a single [BLANK] placeholder that the learner fills by tapping an option. */
data class FillInBlank(
    override val id: String,
    override val instruction: String,
    val codeTemplate: String,
    val options: List<String>,
    val correct: String,
    override val explanation: String,
) : Exercise {
    companion object {
        const val BLANK = "____"
    }
}

/**
 * Duolingo-style word bank: build a line of code from tiles.
 * [tiles] contains every tile shown (solution + distractors).
 */
data class ArrangeTiles(
    override val id: String,
    override val instruction: String,
    val tiles: List<String>,
    val solution: List<String>,
    val alternatives: List<List<String>> = emptyList(),
    override val explanation: String,
) : Exercise

/** The learner types exactly what the program prints. */
data class PredictOutput(
    override val id: String,
    override val instruction: String,
    val code: String,
    val accepted: List<String>,
    override val explanation: String,
) : Exercise

/**
 * A theory card from a module introduction: nothing to answer, the learner reads it
 * and taps "Dalej". [instruction] is the card title; [code] and its [output] are optional.
 */
data class Explanation(
    override val id: String,
    override val instruction: String,
    val text: String,
    val code: String? = null,
    val output: String? = null,
) : Exercise {
    override val explanation: String get() = ""
}

/**
 * [exercises] are the core exercises shown, in order, the first time the lesson is taken.
 * [practice] holds extra exercises on the same topic; replays draw from both.
 */
data class Lesson(
    val id: String,
    val title: String,
    val exercises: List<Exercise>,
    val practice: List<Exercise> = emptyList(),
) {
    val pool: List<Exercise> get() = exercises + practice

    /** A module introduction ("u<N>l0"): theory cards followed by a few easy checks. */
    val isIntro: Boolean get() = id.endsWith("l0")

    /** Theory cards shown before the lesson's exercises. */
    val cards: List<Exercise> get() = exercises.filterIsInstance<Explanation>()
}

data class CourseUnit(
    val id: String,
    val title: String,
    val description: String,
    val lessons: List<Lesson>,
)

/** What the learner submitted for an exercise. */
sealed interface Answer {
    data class Choice(val index: Int) : Answer
    data class Text(val value: String) : Answer
    data class Tiles(val tiles: List<String>) : Answer

    /** A theory card was read. */
    data object Seen : Answer
}
