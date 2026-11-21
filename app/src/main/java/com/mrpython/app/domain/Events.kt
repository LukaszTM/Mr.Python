package com.mrpython.app.domain

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

/** A running XP bonus as the screens show it. */
data class XpEvent(
    val title: String,
    val description: String,
    /** 150 means XP ×1.5. */
    val percent: Int,
    val endsAt: LocalDateTime,
) {
    /** The multiplier as text: "2", "1,5". */
    val multiplier: String get() = Events.label(percent)
}

/** A time-limited XP bonus the learner has earned; stored with the progress. */
data class Boost(val title: String, val percent: Int, val untilMillis: Long)

/**
 * XP bonuses are rewards, not a daily routine:
 * - a welcome bonus right after the first launch,
 * - a bonus each time the streak reaches another 5 days; bigger for round numbers.
 * Each lasts [DURATION_MILLIS] from the moment it is granted.
 */
object Events {
    const val DURATION_MILLIS = 30 * 60 * 1000L
    const val STREAK_STEP = 5

    fun welcome(nowMillis: Long): Boost = Boost("Bonus na start", 200, nowMillis + DURATION_MILLIS)

    /** XP percent for reaching [streak] days, or null when it is not a milestone. */
    fun streakPercent(streak: Int): Int? = when {
        streak <= 0 || streak % STREAK_STEP != 0 -> null
        streak % 30 == 0 -> 300
        streak % 10 == 0 -> 200
        else -> 150
    }

    /** The bonus for reaching [streak] days, or null when it is not a milestone. */
    fun forStreak(streak: Int, nowMillis: Long): Boost? =
        streakPercent(streak)?.let { Boost("Seria ${Moods.days(streak)}", it, nowMillis + DURATION_MILLIS) }

    /** The next streak length that brings a bonus. */
    fun nextMilestone(streak: Int): Int = (streak / STREAK_STEP + 1) * STREAK_STEP

    /** The bonus running at [nowMillis], if any. */
    fun active(progress: Progress, nowMillis: Long, zone: ZoneId = ZoneId.systemDefault()): XpEvent? {
        val boost = progress.boost ?: return null
        if (nowMillis >= boost.untilMillis) return null
        return XpEvent(
            boost.title,
            "Każda lekcja daje teraz XP ×${label(boost.percent)}.",
            boost.percent,
            LocalDateTime.ofInstant(Instant.ofEpochMilli(boost.untilMillis), zone),
        )
    }

    /** XP after the bonus, rounded to the nearest whole point. */
    fun apply(xp: Int, percent: Int): Int = (xp * percent + 50) / 100

    fun label(percent: Int): String =
        if (percent % 100 == 0) "${percent / 100}" else "${percent / 100},${percent % 100 / 10}"
}
