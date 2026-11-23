package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import java.time.LocalDate

class EventsTest {
    private val now = 1_000_000_000L

    @Test
    fun welcomeBonusDoublesXpForHalfAnHour() {
        val p = Progress(boost = Events.welcome(now))
        assertEquals(200, Events.active(p, now)?.percent)
        assertEquals("2", Events.active(p, now + 29 * 60_000)?.multiplier)
        assertNull(Events.active(p, now + 30 * 60_000))
        assertNull(Events.active(Progress(), now))
    }

    @Test
    fun onlyEveryFifthStreakDayIsAMilestone() {
        assertNull(Events.streakPercent(0))
        assertNull(Events.streakPercent(4))
        assertEquals(150, Events.streakPercent(5))
        assertEquals(200, Events.streakPercent(10))
        assertEquals(150, Events.streakPercent(15))
        assertEquals(200, Events.streakPercent(20))
        assertEquals(300, Events.streakPercent(30))
        assertEquals(5, Events.nextMilestone(0))
        assertEquals(10, Events.nextMilestone(5))
        assertEquals(10, Events.nextMilestone(9))
    }

    @Test
    fun labelsAndRounding() {
        assertEquals("1,5", Events.label(150))
        assertEquals("3", Events.label(300))
        assertEquals(15, Events.apply(10, 150))
        assertEquals(23, Events.apply(15, 150))
        assertEquals(8, Events.apply(5, 150))
        assertEquals(10, Events.apply(10, 100))
    }

    @Test
    fun reachingAMilestoneGrantsABonusForTheNextLessons() {
        val today = LocalDate.of(2026, 3, 10)
        val before = Progress(streak = 4, lastActiveEpochDay = today.toEpochDay() - 1)
        val after = Rules.completeLesson(before, "a", 0, today, nowMillis = now)
        assertEquals(5, after.streak)
        assertNotNull(after.boost)
        assertEquals(150, Events.active(after, now)?.percent)
        // The lesson that reached the milestone was still paid at the normal rate.
        assertEquals(Rules.XP_PER_LESSON + Rules.XP_PERFECT_BONUS, after.totalXp)
        // A second lesson the same day does not restart the bonus.
        val again = Rules.completeLesson(after, "b", 0, today, nowMillis = now + 60_000)
        assertEquals(after.boost, again.boost)
    }

    @Test
    fun ordinaryDaysGrantNothing() {
        val today = LocalDate.of(2026, 3, 10)
        val before = Progress(streak = 2, lastActiveEpochDay = today.toEpochDay() - 1)
        assertNull(Rules.completeLesson(before, "a", 0, today, nowMillis = now).boost)
    }
}
