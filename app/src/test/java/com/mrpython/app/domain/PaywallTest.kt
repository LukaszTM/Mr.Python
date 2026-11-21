package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class PaywallTest {
    private val today = LocalDate.of(2026, 3, 10)

    @Test
    fun oneNewLessonADay() {
        val fresh = Progress()
        assertFalse(Paywall.blocksStart(fresh, "u1l1", today))
        val after = Rules.completeLesson(fresh, "u1l1", 0, today)
        assertEquals(today.toEpochDay(), after.lastNewLessonEpochDay)
        assertTrue(Paywall.blocksStart(after, "u1l2", today))
        assertFalse(Paywall.blocksStart(after, "u1l2", today.plusDays(1)))
    }

    @Test
    fun replaysAndIntroductionsAreNeverLimited() {
        val after = Rules.completeLesson(Progress(), "u1l1", 0, today)
        assertFalse(Paywall.blocksStart(after, "u1l1", today))
        assertFalse(Paywall.blocksStart(after, "u2l0", today))
        // Neither of them uses up the day's lesson.
        val intro = Rules.completeLesson(Progress(), "u1l0", 0, today)
        assertEquals(null, intro.lastNewLessonEpochDay)
        val replay = Rules.completeLesson(after, "u1l1", 0, today.plusDays(1))
        assertEquals(today.toEpochDay(), replay.lastNewLessonEpochDay)
    }
}
