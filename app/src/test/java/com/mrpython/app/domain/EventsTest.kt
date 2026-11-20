package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class EventsTest {

    // 2026-11-18 is a Wednesday, 2026-11-21 a Saturday, 2026-12-01 a Tuesday.
    private fun at(day: Int, hour: Int, minute: Int = 0) = LocalDateTime.of(2026, 11, day, hour, minute)

    @Test
    fun noEventOnAnOrdinaryWeekdayAfternoon() {
        assertNull(Events.active(at(18, 15)))
        assertEquals(1, Events.multiplier(at(18, 15)))
    }

    @Test
    fun happyHourRunsFromSevenToNine() {
        assertNull(Events.active(at(18, 18, 59)))
        val event = Events.active(at(18, 19))!!
        assertEquals("Happy hour", event.title)
        assertEquals(2, event.multiplier)
        assertEquals(at(18, 21), event.endsAt)
        assertEquals(2, Events.multiplier(at(18, 20, 59)))
        assertNull(Events.active(at(18, 21)))
    }

    @Test
    fun weekendHackathonLastsUntilMonday() {
        val saturday = Events.active(at(21, 10))!!
        assertEquals("Weekendowy hackathon", saturday.title)
        assertEquals(at(23, 0), saturday.endsAt)
        assertEquals(at(23, 0), Events.active(at(22, 23, 59))!!.endsAt)
        // Happy hour doesn't shorten the weekend event.
        assertEquals("Weekendowy hackathon", Events.active(at(21, 20))!!.title)
        assertNull(Events.active(at(23, 0)))
    }

    @Test
    fun releaseDayBeatsOtherEvents() {
        val event = Events.active(LocalDateTime.of(2026, 12, 1, 19, 30))!!
        assertEquals(3, event.multiplier)
        assertEquals(LocalDateTime.of(2026, 12, 2, 0, 0), event.endsAt)
        // 2027-05-01 is a Saturday: release day still wins over the hackathon.
        assertEquals(3, Events.multiplier(LocalDateTime.of(2027, 5, 1, 12, 0)))
    }

    @Test
    fun nextEventIsTheEarliestUpcomingOne() {
        assertEquals(UpcomingEvent("Happy hour", 2, at(18, 19)), Events.next(at(18, 12)))
        assertEquals(UpcomingEvent("Happy hour", 2, at(19, 19)), Events.next(at(18, 21, 30)))
        // Friday night: the weekend starts before the next happy hour.
        assertEquals(UpcomingEvent("Weekendowy hackathon", 2, at(21, 0)), Events.next(at(20, 22)))
        assertEquals(
            UpcomingEvent("Dzień wdrożenia", 3, LocalDateTime.of(2026, 12, 1, 0, 0)),
            Events.next(at(30, 22)),
        )
    }

    @Test
    fun eventMultipliesLessonXp() {
        val today = LocalDate.of(2026, 11, 21)
        val p = Rules.completeLesson(Progress(), "a", mistakes = 0, today = today, multiplier = 2)
        assertEquals(30, p.totalXp)
        assertEquals(30, p.weekXp)
        assertEquals(30, Rules.visibleXpToday(p, today))
        val replay = Rules.completeLesson(p, "a", mistakes = 3, today = today, multiplier = 3)
        assertEquals(30 + 15, replay.totalXp)
    }
}
