package com.mrpython.app.domain

import java.time.LocalDateTime

/** How the snake feels about the learner's streak; it picks the picture on the home screen widget. */
enum class SnakeMood { HAPPY, BORED, WORRIED, SAD }

/** What the home screen widget shows. */
data class WidgetState(val mood: SnakeMood, val streak: Int, val text: String)

object Moods {
    /** From this hour on, a day without a lesson starts to worry the snake. */
    const val WORRY_HOUR = 18

    fun state(progress: Progress, now: LocalDateTime): WidgetState {
        val today = now.toLocalDate()
        val streak = Rules.visibleStreak(progress, today)
        return when {
            progress.lastActiveEpochDay == today.toEpochDay() ->
                WidgetState(SnakeMood.HAPPY, streak, "Dzisiejsza lekcja zaliczona!")
            streak > 0 && now.hour >= WORRY_HOUR ->
                WidgetState(SnakeMood.WORRIED, streak, "Seria zagrożona! Zrób lekcję przed północą.")
            streak > 0 ->
                WidgetState(SnakeMood.BORED, streak, "Nudzę się… Czas na dzisiejszą lekcję.")
            progress.lastActiveEpochDay != null ->
                WidgetState(SnakeMood.SAD, 0, "Seria przepadła. Zacznij nową!")
            else ->
                WidgetState(SnakeMood.BORED, 0, "Zacznij pierwszą lekcję!")
        }
    }

    /** "1 dzień", "5 dni". */
    fun days(count: Int): String = if (count == 1) "1 dzień" else "$count dni"
}
