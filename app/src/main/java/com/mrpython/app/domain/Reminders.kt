package com.mrpython.app.domain

import java.time.LocalDate
import java.time.LocalDateTime

data class ReminderMessage(val title: String, val text: String)

enum class ReminderKind {
    /** The daily nudge at the hour the learner picked. */
    DAILY,

    /** A late evening warning that the streak is about to be lost. */
    STREAK_RESCUE,
}

/** Texts of lesson reminders, in the spirit of Duolingo's nudges. */
object Reminders {
    const val DEFAULT_HOUR = 19
    const val STREAK_RESCUE_HOUR = 22

    private val daily = listOf(
        "Czas na Pythona! 🐍" to "Jedna krótka lekcja i cel dzienny będzie bliżej.",
        "print(\"Wracaj do nauki!\")" to "Twoja dzisiejsza lekcja czeka. To tylko kilka minut.",
        "Kod sam się nie napisze 💻" to "Zrób dziś jedną lekcję i utrzymaj tempo.",
        "while True: ucz_sie()" to "Pętla nauki czeka na kolejny obrót. Wpadnij na lekcję!",
        "Mr. Python tęskni 🐍" to "Rywale w lidze nie śpią. Zdobądź dziś trochę XP.",
    )

    /**
     * The message to show, or null when no reminder is needed: the learner has already
     * done a lesson today, or there is no streak to rescue.
     */
    fun message(progress: Progress, kind: ReminderKind, now: LocalDateTime): ReminderMessage? {
        val today: LocalDate = now.toLocalDate()
        if (progress.lastActiveEpochDay == today.toEpochDay()) return null
        val streak = Rules.visibleStreak(progress, today)
        return when (kind) {
            ReminderKind.STREAK_RESCUE -> if (streak == 0) {
                null
            } else {
                ReminderMessage(
                    "Twoja seria $streak dni zaraz przepadnie! 🔥",
                    "Zostało niewiele czasu do północy. Jedna lekcja wystarczy, żeby ją uratować.",
                )
            }
            ReminderKind.DAILY -> {
                when {
                    streak > 0 -> ReminderMessage(
                        "Utrzymaj serię $streak dni 🔥",
                        "Zrób dziś jedną lekcję, żeby seria rosła dalej.",
                    )
                    else -> daily[Math.floorMod(today.toEpochDay(), daily.size.toLong()).toInt()]
                        .let { (title, text) -> ReminderMessage(title, text) }
                }
            }
        }
    }
}
