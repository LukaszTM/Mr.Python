package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDateTime

class RemindersTest {

    // A Wednesday afternoon with no event running.
    private val now = LocalDateTime.of(2026, 11, 18, 15, 0)
    private val today = now.toLocalDate().toEpochDay()

    @Test
    fun noReminderAfterTodaysLesson() {
        val done = Progress(streak = 4, lastActiveEpochDay = today)
        assertNull(Reminders.message(done, ReminderKind.DAILY, now))
        assertNull(Reminders.message(done, ReminderKind.STREAK_RESCUE, now))
    }

    @Test
    fun dailyReminderMentionsTheStreak() {
        val p = Progress(streak = 4, lastActiveEpochDay = today - 1)
        assertTrue(Reminders.message(p, ReminderKind.DAILY, now)!!.title.contains("4"))
    }

    @Test
    fun dailyReminderWithoutStreakRotatesGenericTexts() {
        val a = Reminders.message(Progress(), ReminderKind.DAILY, now)!!
        val b = Reminders.message(Progress(), ReminderKind.DAILY, now.plusDays(1))!!
        assertTrue(a != b)
        // A streak lost days ago no longer counts.
        val lost = Progress(streak = 9, lastActiveEpochDay = today - 5)
        assertEquals(a, Reminders.message(lost, ReminderKind.DAILY, now))
    }

    @Test
    fun streakRescueOnlyWhenThereIsAStreakToLose() {
        val late = now.withHour(22)
        assertNull(Reminders.message(Progress(), ReminderKind.STREAK_RESCUE, late))
        val p = Progress(streak = 12, lastActiveEpochDay = today - 1)
        assertTrue(Reminders.message(p, ReminderKind.STREAK_RESCUE, late)!!.title.contains("12"))
    }
}
