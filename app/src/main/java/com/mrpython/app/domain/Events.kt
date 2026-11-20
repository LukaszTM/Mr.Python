package com.mrpython.app.domain

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

/** A time-limited event that multiplies the XP earned for lessons. */
data class XpEvent(
    val title: String,
    val description: String,
    val multiplier: Int,
    val endsAt: LocalDateTime,
)

data class UpcomingEvent(val title: String, val multiplier: Int, val startsAt: LocalDateTime)

/**
 * Recurring XP events. They follow the calendar, so they need no server:
 * - "Dzień wdrożenia": the 1st day of every month, XP ×3;
 * - "Weekendowy hackathon": every Saturday and Sunday, XP ×2;
 * - "Happy hour": every day from 19:00 to 21:00, XP ×2.
 */
object Events {
    val HAPPY_HOUR_START: LocalTime = LocalTime.of(19, 0)
    val HAPPY_HOUR_END: LocalTime = LocalTime.of(21, 0)

    private fun isWeekend(day: DayOfWeek) = day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY

    /** The event running at [now]; when several overlap, the biggest multiplier wins. */
    fun active(now: LocalDateTime): XpEvent? {
        val date = now.toLocalDate()
        val running = mutableListOf<XpEvent>()
        if (date.dayOfMonth == 1) {
            running += XpEvent(
                "Dzień wdrożenia",
                "Pierwszy dzień miesiąca: każda lekcja daje potrójne XP.",
                3,
                date.plusDays(1).atStartOfDay(),
            )
        }
        if (isWeekend(date.dayOfWeek)) {
            val monday = date.plusDays(if (date.dayOfWeek == DayOfWeek.SATURDAY) 2 else 1)
            running += XpEvent(
                "Weekendowy hackathon",
                "Przez cały weekend każda lekcja daje podwójne XP.",
                2,
                monday.atStartOfDay(),
            )
        }
        val time = now.toLocalTime()
        if (time >= HAPPY_HOUR_START && time < HAPPY_HOUR_END) {
            running += XpEvent(
                "Happy hour",
                "Codziennie od 19:00 do 21:00 każda lekcja daje podwójne XP.",
                2,
                date.atTime(HAPPY_HOUR_END),
            )
        }
        return running.sortedWith(compareByDescending<XpEvent> { it.multiplier }.thenByDescending { it.endsAt })
            .firstOrNull()
    }

    fun multiplier(now: LocalDateTime): Int = active(now)?.multiplier ?: 1

    /** The next event to start after [now]. */
    fun next(now: LocalDateTime): UpcomingEvent {
        val date = now.toLocalDate()
        val happyHourDay = if (now.toLocalTime() < HAPPY_HOUR_START) date else date.plusDays(1)
        var saturday = date.plusDays(1)
        while (saturday.dayOfWeek != DayOfWeek.SATURDAY) saturday = saturday.plusDays(1)
        val firstOfMonth = date.plusMonths(1).withDayOfMonth(1)
        return listOf(
            UpcomingEvent("Happy hour", 2, happyHourDay.atTime(HAPPY_HOUR_START)),
            UpcomingEvent("Weekendowy hackathon", 2, saturday.atStartOfDay()),
            UpcomingEvent("Dzień wdrożenia", 3, firstOfMonth.atStartOfDay()),
        ).minBy { it.startsAt }
    }
}
