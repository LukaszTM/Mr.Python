package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class MoodsTest {
    private val noon = LocalDateTime.of(2026, 3, 10, 12, 0)
    private val evening = LocalDateTime.of(2026, 3, 10, 20, 0)
    private val today = noon.toLocalDate().toEpochDay()

    private fun mood(progress: Progress, now: LocalDateTime) = Moods.state(progress, now)

    @Test
    fun happyAfterTodaysLesson() {
        val state = mood(Progress(streak = 4, lastActiveEpochDay = today), evening)
        assertEquals(SnakeMood.HAPPY, state.mood)
        assertEquals(4, state.streak)
    }

    @Test
    fun boredDuringTheDayAndWorriedInTheEvening() {
        val p = Progress(streak = 4, lastActiveEpochDay = today - 1)
        assertEquals(SnakeMood.BORED, mood(p, noon).mood)
        assertEquals(SnakeMood.WORRIED, mood(p, evening).mood)
        assertEquals(4, mood(p, evening).streak)
    }

    @Test
    fun sadOnceTheStreakIsLost() {
        val state = mood(Progress(streak = 4, lastActiveEpochDay = today - 2), noon)
        assertEquals(SnakeMood.SAD, state.mood)
        assertEquals(0, state.streak)
    }

    @Test
    fun newLearnerIsInvitedToStart() {
        assertEquals(SnakeMood.BORED, mood(Progress(), evening).mood)
    }

    @Test
    fun dayWord() {
        assertEquals("1 dzień", Moods.days(1))
        assertEquals("12 dni", Moods.days(12))
    }
}
