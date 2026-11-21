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
                WidgetState(SnakeMood.HAPPY, streak, "Dzisiejsza lekcja zaliczona!".t())
            streak > 0 && now.hour >= WORRY_HOUR ->
                WidgetState(SnakeMood.WORRIED, streak, "Seria zagrożona! Zrób lekcję przed północą.".t())
            streak > 0 ->
                WidgetState(SnakeMood.BORED, streak, "Nudzę się… Czas na dzisiejszą lekcję.".t())
            progress.lastActiveEpochDay != null ->
                WidgetState(SnakeMood.SAD, 0, "Seria przepadła. Zacznij nową!".t())
            else ->
                WidgetState(SnakeMood.BORED, 0, "Zacznij pierwszą lekcję!".t())
        }
    }

    /** "1 dzień", "5 dni"; in English "1 day", "5 days". */
    fun days(count: Int): String = when (I18n.language) {
        Language.EN -> if (count == 1) "1 day" else "$count days"
        Language.PL -> if (count == 1) "1 dzień" else "$count dni"
    }
}
