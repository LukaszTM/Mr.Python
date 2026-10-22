package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LessonSessionTest {

    private fun ex(id: String) = MultipleChoice(id, "?", null, listOf("a"), 0, "")
    private val lesson = Lesson("l", "L", listOf(ex("1"), ex("2"), ex("3")))

    @Test
    fun correctAnswersAdvance() {
        var s = LessonSession.start(lesson)
        repeat(3) { s = s.afterAnswer(correct = true) }
        assertTrue(s.isFinished)
        assertEquals(1f, s.progress)
        assertEquals(0, s.mistakes)
    }

    @Test
    fun wrongAnswerIsRetriedAtTheEnd() {
        var s = LessonSession.start(lesson)
        s = s.afterAnswer(correct = false)
        assertEquals(listOf("2", "3", "1"), s.queue.map { it.id })
        assertEquals(0f, s.progress)
        s = s.afterAnswer(true).afterAnswer(true)
        assertEquals("1", s.current?.id)
        s = s.afterAnswer(true)
        assertTrue(s.isFinished)
        assertEquals(1, s.mistakes)
    }
}
