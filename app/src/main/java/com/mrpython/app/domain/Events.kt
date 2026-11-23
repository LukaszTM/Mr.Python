package com.mrpython.app.domain

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

/** A running XP bonus as the screens show it. */
data class XpEvent(
    /** Already in the language it is shown in. */
    val title: String,
    val description: String,
    /** 150 means XP ×1.5. */
    val percent: Int,
    val endsAt: LocalDateTime,
) {
    /** The multiplier as text: "2", "1,5". */
    val multiplier: String get() = Events.label(percent)
}

/**
 * A time-limited XP bonus the learner has earned; stored with the progress.
 * [title] is always the Polish one, whatever the language; [Events.title] translates it for the screen.
 */
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

    private const val WELCOME_TITLE = "Bonus na start"
    private val streakTitle = Regex("Seria (\\d+) dni")

    /** The welcome bonus is a taste of the full version, so the free version gets it too. */
    fun isWelcome(boost: Boost?): Boolean = boost?.title == WELCOME_TITLE

    fun welcome(nowMillis: Long): Boost = Boost(WELCOME_TITLE, 200, nowMillis + DURATION_MILLIS)

    /** XP percent for reaching [streak] days, or null when it is not a milestone. */
    fun streakPercent(streak: Int): Int? = when {
        streak <= 0 || streak % STREAK_STEP != 0 -> null
        streak % 30 == 0 -> 300
        streak % 10 == 0 -> 200
        else -> 150
    }

    /** The bonus for reaching [streak] days, or null when it is not a milestone. */
    fun forStreak(streak: Int, nowMillis: Long): Boost? =
        streakPercent(streak)?.let { Boost("Seria $streak dni", it, nowMillis + DURATION_MILLIS) }

    /** The stored (Polish) title of [boost] in the current language. */
    fun title(boost: Boost): String {
        if (boost.title == WELCOME_TITLE) return WELCOME_TITLE.t()
        val days = streakTitle.matchEntire(boost.title)?.groupValues?.get(1) ?: return boost.title
        return "Seria {0} dni".t(days)
    }

    /** The next streak length that brings a bonus. */
    fun nextMilestone(streak: Int): Int = (streak / STREAK_STEP + 1) * STREAK_STEP

    /** The bonus running at [nowMillis], if any. */
    fun active(progress: Progress, nowMillis: Long, zone: ZoneId = ZoneId.systemDefault()): XpEvent? {
        val boost = progress.boost ?: return null
        if (nowMillis >= boost.untilMillis) return null
        return XpEvent(
            title(boost),
            "Każda lekcja daje teraz XP ×{0}.".t(label(boost.percent)),
            boost.percent,
            LocalDateTime.ofInstant(Instant.ofEpochMilli(boost.untilMillis), zone),
        )
    }

    /** XP after the bonus, rounded to the nearest whole point. */
    fun apply(xp: Int, percent: Int): Int = (xp * percent + 50) / 100

    /** "2", "1,5"; English uses a decimal point: "1.5". */
    fun label(percent: Int): String {
        val separator = if (I18n.language == Language.EN) "." else ","
        return if (percent % 100 == 0) "${percent / 100}" else "${percent / 100}$separator${percent % 100 / 10}"
    }
}
