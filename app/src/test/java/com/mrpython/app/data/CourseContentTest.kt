package com.mrpython.app.data

import com.mrpython.app.domain.Answer
import com.mrpython.app.domain.AnswerChecker
import com.mrpython.app.domain.ArrangeTiles
import com.mrpython.app.domain.Explanation
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
    fun everyModuleStartsWithAnIntroduction() {
        CourseContent.units.forEach { unit ->
            val first = unit.lessons.first()
            assertEquals(unit.id, unit.id + "l0", first.id)
            assertTrue(unit.id, first.isIntro)
            assertTrue(unit.id, unit.lessons.drop(1).none { it.isIntro })
        }
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
                is Explanation -> assertTrue(e.id, e.text.isNotBlank())
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
                is Explanation -> Answer.Seen
            }
            assertTrue(e.id, AnswerChecker.isCorrect(e, answer))
        }
    }

    @Test
    fun englishCourseMirrorsThePolishOne() {
        val pl = CoursePl.units
        val en = CourseEn.units
        assertEquals(pl.map { it.id }, en.map { it.id })
        pl.zip(en).forEach { (a, b) ->
            assertEquals(a.id, a.lessons.map { it.id }, b.lessons.map { it.id })
            a.lessons.zip(b.lessons).forEach { (x, y) ->
                // Same exercises in the same order, so progress and replays work in both languages.
                assertEquals(x.id, x.pool.map { it.id to it::class }, y.pool.map { it.id to it::class })
            }
        }
    }

    @Test
    fun tilesAcceptAnEquivalentOrder() {
        val swapped = CoursePl.units.flatMap { it.lessons }.flatMap { it.pool }
            .filterIsInstance<ArrangeTiles>().filter { it.alternatives.isNotEmpty() }
        assertTrue(swapped.isNotEmpty())
        swapped.forEach { exercise ->
            exercise.alternatives.forEach { alternative ->
                // Same tiles in another order, and the checker takes it.
                assertEquals(exercise.id, exercise.solution.sorted(), alternative.sorted())
                assertTrue(exercise.id, AnswerChecker.isCorrect(exercise, Answer.Tiles(alternative)))
            }
        }
    }
}
