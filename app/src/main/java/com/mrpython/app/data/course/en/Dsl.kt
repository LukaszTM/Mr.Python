package com.mrpython.app.data.course.en

import com.mrpython.app.data.course.ExerciseFactory
import com.mrpython.app.domain.PredictOutput

/** Same as the shared `output`, with the default question in English. */
internal fun output(
    code: String,
    expected: String,
    explanation: String,
    instruction: String = "What will this program print?",
): ExerciseFactory = { id -> PredictOutput(id, instruction, code, listOf(expected), explanation) }
