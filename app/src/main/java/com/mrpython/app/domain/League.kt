package com.mrpython.app.domain

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters
import kotlin.math.pow
import kotlin.random.Random

/** Career ladder used as league tiers. */
enum class Tier(val title: String) {
    INTERN("Stażysta"),
    JUNIOR("Junior Developer"),
    MID("Mid Developer"),
    SENIOR("Senior Developer"),
    TECH_LEAD("Tech Lead"),
    ARCHITECT("Architekt"),
    CTO("CTO");

    val next: Tier? get() = entries.getOrNull(ordinal + 1)
}

data class Standing(val rank: Int, val name: String, val xp: Int, val isPlayer: Boolean)

/** What happened when a league week ended; shown to the learner once. */
data class WeekResult(val rank: Int, val promotedTo: Tier?)

/**
 * Weekly league against simulated rivals (no server needed). Every week the player
 * is grouped with [RIVALS] rivals whose XP is generated deterministically from the
 * week and tier, so the table looks the same every time the app is opened.
 * The top [PROMOTION_SLOTS] players at the end of the week move one tier up.
 */
object League {
    const val RIVALS = 19
    const val PROMOTION_SLOTS = 3

    private val names = listOf(
        "Ania_dev", "kuba.py", "MarekCodes", "Ola_K", "pythonista_jan", "Zosia.exe", "tomek_404",
        "Natalia", "bajtek", "Krzysiek_PL", "Ewa.json", "Pawel_git", "Magda_SQL", "robocop_77",
        "Iga.lambda", "Bartek_bug", "Hania_API", "mr_kotlin", "Wiktor.c", "Lena_ML", "Szymon_dev",
        "Julka_CSS", "Filip.rs", "Ala_ma_kota", "Igor_ops", "Kasia.sh", "Michal_null", "Basia_UX",
        "Olek_Linux", "Nina.yaml", "Adam_py3", "Gosia_dev", "Darek_SRE", "Marta.io", "Kamil_cpp",
        "Ula_data", "Piotrek_JS", "Dominika.pl", "Stas_404", "Weronika",
    )

    /** Monday of the week containing [date]. */
    fun weekStart(date: LocalDate): LocalDate = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

    /** How far through the week [now] is, from 0 (Monday 00:00) to 1 (next Monday). */
    fun weekFraction(now: LocalDateTime, weekStart: LocalDate): Double {
        val minutes = ChronoUnit.MINUTES.between(weekStart.atStartOfDay(), now)
        return (minutes / (7.0 * 24 * 60)).coerceIn(0.0, 1.0)
    }

    private class Rival(val name: String, val finalXp: Int, val pace: Double)

    private fun rivals(weekStart: LocalDate, tier: Tier): List<Rival> {
        val random = Random(weekStart.toEpochDay() * 31 + tier.ordinal)
        val maxXp = 120 + 45 * tier.ordinal
        return names.shuffled(random).take(RIVALS).map { name ->
            // Skewed so most rivals are moderate and a few are very active.
            val xp = (maxXp * random.nextDouble().pow(1.6)).toInt()
            Rival(name, xp, pace = 0.6 + random.nextDouble())
        }
    }

    /**
     * The league table at [fraction] of the week. Rivals gain XP gradually during the
     * week; at fraction 1.0 they have their final totals. Ties go to the player.
     */
    fun standings(weekStart: LocalDate, tier: Tier, playerXp: Int, fraction: Double): List<Standing> {
        val rows = rivals(weekStart, tier).map {
            Triple(it.name, (it.finalXp * fraction.pow(it.pace)).toInt(), false)
        } + Triple("Ty", playerXp, true)
        return rows
            .sortedWith(compareByDescending<Triple<String, Int, Boolean>> { it.second }.thenByDescending { it.third })
            .mapIndexed { i, (name, xp, isPlayer) -> Standing(i + 1, name, xp, isPlayer) }
    }

    fun finalRank(weekStart: LocalDate, tier: Tier, playerXp: Int): Int =
        standings(weekStart, tier, playerXp, 1.0).first { it.isPlayer }.rank
}
