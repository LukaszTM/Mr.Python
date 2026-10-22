package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

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
    fun firstAttemptUsesCoreExercisesAndReplayDrawsFromThePool() {
        val big = Lesson("l", "L", listOf(ex("1"), ex("2")), practice = (3..20).map { ex("$it") })
        assertEquals(listOf("1", "2"), LessonSession.start(big).queue.map { it.id })
        val replay = LessonSession.start(big, replay = true, random = Random(1))
        assertEquals(LessonSession.REPLAY_SIZE, replay.total)
        assertEquals(replay.queue.size, replay.queue.map { it.id }.toSet().size)
        assertTrue(replay.queue.all { it in big.pool })
        // A small lesson replays all of its exercises.
        assertEquals(3, LessonSession.start(lesson, replay = true).total)
    }

    @Test
    fun introIsAlwaysReadInOrder() {
        val cards = (1..4).map { Explanation("c$it", "Karta $it", "Tekst") }
        val intro = Lesson("u1l0", "Wprowadzenie", cards + ex("q"))
        assertTrue(intro.isIntro)
        assertEquals(intro.exercises, LessonSession.start(intro, replay = true, random = Random(7)).queue)
    }

    @Test
    fun lessonCardsComeFirstAndAreShownAgainOnReplay() {
        val cards = listOf(Explanation("l-c1", "Karta", "Tekst"), Explanation("l-c2", "Karta 2", "Tekst"))
        val withCards = Lesson("u1l3", "L", cards + (1..5).map { ex("$it") }, practice = (6..20).map { ex("$it") })
        assertEquals(cards, LessonSession.start(withCards).queue.take(2))
        val replay = LessonSession.start(withCards, replay = true, random = Random(3))
        assertEquals(cards, replay.queue.take(2))
        assertEquals(2 + LessonSession.REPLAY_SIZE, replay.total)
        assertTrue(replay.queue.drop(2).none { it is Explanation })
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
