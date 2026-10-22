package com.mrpython.app.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class LeagueTest {

    private val monday = LocalDate.of(2026, 10, 19)

    @Test
    fun weekStartsOnMonday() {
        assertEquals(monday, League.weekStart(LocalDate.of(2026, 10, 25)))
        assertEquals(monday, League.weekStart(monday))
        assertEquals(0.5, League.weekFraction(LocalDateTime.of(2026, 10, 22, 12, 0), monday), 1e-9)
    }

    @Test
    fun tableIsDeterministicSortedAndHasTwentyPlayers() {
        val a = League.standings(monday, Tier.JUNIOR, playerXp = 50, fraction = 0.7)
        val b = League.standings(monday, Tier.JUNIOR, playerXp = 50, fraction = 0.7)
        assertEquals(a, b)
        assertEquals(League.RIVALS + 1, a.size)
        assertEquals(1, a.count { it.isPlayer })
        assertEquals(a.sortedByDescending { it.xp }.map { it.xp }, a.map { it.xp })
        assertEquals((1..20).toList(), a.map { it.rank })
    }

    @Test
    fun rivalsGainXpDuringTheWeek() {
        val start = League.standings(monday, Tier.MID, 0, 0.0).filterNot { it.isPlayer }.sumOf { it.xp }
        val end = League.standings(monday, Tier.MID, 0, 1.0).filterNot { it.isPlayer }.sumOf { it.xp }
        assertEquals(0, start)
        assertTrue(end > 0)
    }

    @Test
    fun higherTiersAreHarder() {
        fun third(tier: Tier) = League.standings(monday, tier, 0, 1.0).filterNot { it.isPlayer }[2].xp
        assertTrue(third(Tier.CTO) > third(Tier.INTERN))
    }

    @Test
    fun topThreeArePromotedWhenTheWeekEnds() {
        val p = Progress(leagueWeekStartEpochDay = monday.toEpochDay(), weekXp = 10_000)
        val next = Rules.rolloverLeague(p, monday.plusDays(7))
        assertEquals(Tier.JUNIOR, next.leagueTier)
        assertEquals(WeekResult(1, Tier.JUNIOR), next.pendingWeekResult)
        assertEquals(0, next.weekXp)
        assertEquals(monday.plusDays(7).toEpochDay(), next.leagueWeekStartEpochDay)
    }

    @Test
    fun lowRankIsNotPromoted() {
        val p = Progress(leagueTier = Tier.SENIOR, leagueWeekStartEpochDay = monday.toEpochDay(), weekXp = 1)
        val next = Rules.rolloverLeague(p, monday.plusDays(9))
        assertEquals(Tier.SENIOR, next.leagueTier)
        assertTrue(next.pendingWeekResult!!.rank > League.PROMOTION_SLOTS)
        assertNull(next.pendingWeekResult!!.promotedTo)
    }

    @Test
    fun ctoStaysCtoAndEmptyWeeksDontCount() {
        val cto = Progress(leagueTier = Tier.CTO, leagueWeekStartEpochDay = monday.toEpochDay(), weekXp = 10_000)
        assertEquals(Tier.CTO, Rules.rolloverLeague(cto, monday.plusDays(7)).leagueTier)
        val idle = Progress(leagueWeekStartEpochDay = monday.toEpochDay(), weekXp = 0)
        assertNull(Rules.rolloverLeague(idle, monday.plusDays(14)).pendingWeekResult)
    }

    @Test
    fun sameWeekDoesNothingAndLessonsAddWeeklyXp() {
        val p = Progress(leagueWeekStartEpochDay = monday.toEpochDay(), weekXp = 20)
        assertEquals(p, Rules.rolloverLeague(p, monday.plusDays(3)))
        val after = Rules.completeLesson(p, "a", mistakes = 0, today = monday.plusDays(3))
        assertEquals(20 + Rules.XP_PER_LESSON + Rules.XP_PERFECT_BONUS, after.weekXp)
        assertFalse(after.pendingWeekResult != null)
    }
}
