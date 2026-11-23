package com.mrpython.app.data.course

import com.mrpython.app.domain.ArrangeTiles
import com.mrpython.app.domain.Exercise
import com.mrpython.app.domain.Explanation
import com.mrpython.app.domain.FillInBlank
import com.mrpython.app.domain.Lesson
import com.mrpython.app.domain.MultipleChoice
import com.mrpython.app.domain.PredictOutput

internal typealias ExerciseFactory = (id: String) -> Exercise

internal fun lesson(id: String, title: String, vararg exercises: ExerciseFactory) =
    Lesson(id, title, exercises.mapIndexed { i, make -> make("$id-e${i + 1}") })

/** Theory cards shown at the start of the lesson [lessonId]; their ids are "<lessonId>-c<n>". */
internal fun cards(lessonId: String, vararg cards: ExerciseFactory): Pair<String, List<Exercise>> =
    lessonId to cards.mapIndexed { i, make -> make("$lessonId-c${i + 1}") }

/** Extra practice exercises for the lesson [lessonId]; their ids are "<lessonId>-p<n>". */
internal fun practice(lessonId: String, vararg exercises: ExerciseFactory): Pair<String, List<Exercise>> =
    lessonId to exercises.mapIndexed { i, make -> make("$lessonId-p${i + 1}") }

/** A theory card for a module introduction. */
internal fun explain(
    title: String,
    text: String,
    code: String? = null,
    output: String? = null,
): ExerciseFactory = { id -> Explanation(id, title, text, code, output) }

internal fun choice(
    instruction: String,
    options: List<String>,
    correct: Int,
    explanation: String,
    code: String? = null,
): ExerciseFactory = { id -> MultipleChoice(id, instruction, code, options, correct, explanation) }

internal fun fill(
    instruction: String,
    code: String,
    options: List<String>,
    correct: String,
    explanation: String,
): ExerciseFactory = { id -> FillInBlank(id, instruction, code, options, correct, explanation) }

internal fun tiles(
    instruction: String,
    solution: List<String>,
    distractors: List<String>,
    explanation: String,
): ExerciseFactory = { id -> ArrangeTiles(id, instruction, solution + distractors, solution, explanation = explanation) }

internal fun output(
    code: String,
    expected: String,
    explanation: String,
    instruction: String = "Co wypisze ten program?",
): ExerciseFactory = { id -> PredictOutput(id, instruction, code, listOf(expected), explanation) }
