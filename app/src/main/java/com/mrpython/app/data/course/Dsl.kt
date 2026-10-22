package com.mrpython.app.data.course

import com.mrpython.app.domain.ArrangeTiles
import com.mrpython.app.domain.Exercise
import com.mrpython.app.domain.FillInBlank
import com.mrpython.app.domain.Lesson
import com.mrpython.app.domain.MultipleChoice
import com.mrpython.app.domain.PredictOutput

internal typealias ExerciseFactory = (id: String) -> Exercise

internal fun lesson(id: String, title: String, vararg exercises: ExerciseFactory) =
    Lesson(id, title, exercises.mapIndexed { i, make -> make("$id-e${i + 1}") })

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
