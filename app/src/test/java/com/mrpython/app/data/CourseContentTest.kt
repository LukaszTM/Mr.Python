package com.mrpython.app.data

import com.mrpython.app.domain.Answer
import com.mrpython.app.domain.AnswerChecker
import com.mrpython.app.domain.ArrangeTiles
import com.mrpython.app.domain.FillInBlank
import com.mrpython.app.domain.MultipleChoice
import com.mrpython.app.domain.PredictOutput
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CourseContentTest {

    private val exercises = CourseContent.allLessons.flatMap { it.pool }

    @Test
    fun idsAreUnique() {
        assertEquals(CourseContent.units.size, CourseContent.units.map { it.id }.toSet().size)
        assertEquals(CourseContent.allLessons.size, CourseContent.allLessons.map { it.id }.toSet().size)
        assertEquals(exercises.size, exercises.map { it.id }.toSet().size)
    }

    @Test
    fun everyLessonHasExercises() {
        CourseContent.allLessons.forEach { assertTrue(it.id, it.exercises.size >= 3) }
    }

    @Test
    fun exercisesAreWellFormed() {
        exercises.forEach { e ->
            when (e) {
                is MultipleChoice -> assertTrue(e.id, e.correctIndex in e.options.indices)
                is FillInBlank -> {
                    assertTrue(e.id, e.correct in e.options)
                    assertEquals(e.id, 1, e.codeTemplate.split(FillInBlank.BLANK).size - 1)
                }
                is ArrangeTiles -> {
                    val pool = e.tiles.toMutableList()
                    e.solution.forEach { assertTrue("${e.id}: $it", pool.remove(it)) }
                    assertTrue(e.id, e.tiles.size > e.solution.size)
                }
                is PredictOutput -> assertTrue(e.id, e.accepted.isNotEmpty())
            }
        }
    }

    @Test
    fun correctAnswerTextIsAccepted() {
        exercises.forEach { e ->
            val answer = when (e) {
                is MultipleChoice -> Answer.Choice(e.correctIndex)
                is FillInBlank -> Answer.Choice(e.options.indexOf(e.correct))
                is ArrangeTiles -> Answer.Tiles(e.solution)
                is PredictOutput -> Answer.Text(AnswerChecker.correctAnswerText(e))
            }
            assertTrue(e.id, AnswerChecker.isCorrect(e, answer))
        }
    }
}
