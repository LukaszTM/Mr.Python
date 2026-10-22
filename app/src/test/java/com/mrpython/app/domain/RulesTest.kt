package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class RulesTest {

    private val today = LocalDate.of(2026, 10, 22)
    private val minute = 60_000L

    @Test
    fun heartsRegenerateOverTime() {
        var p = Progress()
        p = Rules.loseHeart(p, nowMillis = 0)
        p = Rules.loseHeart(p, nowMillis = 5 * minute)
        assertEquals(3, p.hearts)
        assertEquals(0L, p.heartsRefillStartMillis)

        p = Rules.refillHearts(p, nowMillis = 19 * minute)
        assertEquals(3, p.hearts)
        assertEquals(minute, Rules.millisToNextHeart(p, 19 * minute))

        p = Rules.refillHearts(p, nowMillis = 25 * minute)
        assertEquals(4, p.hearts)
        assertEquals(20 * minute, p.heartsRefillStartMillis)

        p = Rules.refillHearts(p, nowMillis = 3 * 60 * minute)
        assertEquals(Rules.MAX_HEARTS, p.hearts)
        assertNull(p.heartsRefillStartMillis)
    }

    @Test
    fun cannotGoBelowZeroHearts() {
        val p = Progress(hearts = 0, heartsRefillStartMillis = 0)
        assertEquals(0, Rules.loseHeart(p, 1).hearts)
    }

    @Test
    fun streakGrowsOnConsecutiveDaysAndResetsAfterGap() {
        var p = Rules.completeLesson(Progress(), "a", 0, today)
        assertEquals(1, p.streak)
        p = Rules.completeLesson(p, "b", 0, today)
        assertEquals(1, p.streak)
        p = Rules.completeLesson(p, "c", 0, today.plusDays(1))
        assertEquals(2, p.streak)
        assertEquals(2, Rules.visibleStreak(p, today.plusDays(2)))
        assertEquals(0, Rules.visibleStreak(p, today.plusDays(3)))
        p = Rules.completeLesson(p, "d", 0, today.plusDays(5))
        assertEquals(1, p.streak)
    }

    @Test
    fun xpAndDailyGoal() {
        var p = Rules.completeLesson(Progress(), "a", mistakes = 0, today = today)
        assertEquals(Rules.XP_PER_LESSON + Rules.XP_PERFECT_BONUS, p.totalXp)
        p = Rules.completeLesson(p, "b", mistakes = 2, today = today)
        assertEquals(25, Rules.visibleXpToday(p, today))
        assertEquals(0, Rules.visibleXpToday(p, today.plusDays(1)))
        p = Rules.completeLesson(p, "c", mistakes = 0, today = today.plusDays(1))
        assertEquals(15, p.xpToday)
    }

    @Test
    fun practiceGivesHeartBack() {
        val start = Progress(completedLessons = setOf("a"), hearts = 2, heartsRefillStartMillis = 0)
        val p = Rules.completeLesson(start, "a", mistakes = 1, today = today)
        assertEquals(3, p.hearts)
        assertEquals(Rules.XP_PRACTICE, p.totalXp)
    }

    @Test
    fun lessonsUnlockInOrder() {
        val course = listOf(
            CourseUnit("u1", "", "", listOf(Lesson("a", "", emptyList()), Lesson("b", "", emptyList()))),
            CourseUnit("u2", "", "", listOf(Lesson("c", "", emptyList()))),
        )
        assertTrue(Rules.isUnlocked(course, "a", emptySet()))
        assertFalse(Rules.isUnlocked(course, "b", emptySet()))
        assertTrue(Rules.isUnlocked(course, "c", setOf("a", "b")))
        assertFalse(Rules.isUnlocked(course, "missing", emptySet()))
        assertEquals("b", Rules.currentLessonId(course, setOf("a")))
        assertNull(Rules.currentLessonId(course, setOf("a", "b", "c")))
    }
}
