package com.mrpython.app.domain

import java.time.LocalDate

/** Everything we remember about the learner between app launches. */
data class Progress(
    val completedLessons: Set<String> = emptySet(),
    val totalXp: Int = 0,
    val hearts: Int = Rules.MAX_HEARTS,
    /** When the oldest missing heart started regenerating; null when hearts are full. */
    val heartsRefillStartMillis: Long? = null,
    val streak: Int = 0,
    val lastActiveEpochDay: Long? = null,
    val xpToday: Int = 0,
    val xpTodayEpochDay: Long? = null,
    val leagueTier: Tier = Tier.INTERN,
    /** Monday of the league week that [weekXp] belongs to. */
    val leagueWeekStartEpochDay: Long? = null,
    val weekXp: Int = 0,
    /** Result of the last finished week, until the learner has seen it. */
    val pendingWeekResult: WeekResult? = null,
)

object Rules {
    const val MAX_HEARTS = 5
    const val HEART_REFILL_MILLIS = 20 * 60 * 1000L
    const val XP_PER_LESSON = 10
    const val XP_PERFECT_BONUS = 5
    const val XP_PRACTICE = 5
    const val DAILY_GOAL_XP = 30

    /** Hearts regenerate one every [HEART_REFILL_MILLIS]. */
    fun refillHearts(p: Progress, nowMillis: Long): Progress {
        val start = p.heartsRefillStartMillis ?: return p
        if (p.hearts >= MAX_HEARTS) return p.copy(heartsRefillStartMillis = null)
        val gained = ((nowMillis - start) / HEART_REFILL_MILLIS).toInt().coerceAtLeast(0)
        if (gained == 0) return p
        val hearts = (p.hearts + gained).coerceAtMost(MAX_HEARTS)
        return p.copy(
            hearts = hearts,
            heartsRefillStartMillis = if (hearts >= MAX_HEARTS) null else start + gained * HEART_REFILL_MILLIS,
        )
    }

    fun millisToNextHeart(p: Progress, nowMillis: Long): Long? {
        val start = p.heartsRefillStartMillis ?: return null
        if (p.hearts >= MAX_HEARTS) return null
        return (start + HEART_REFILL_MILLIS - nowMillis).coerceAtLeast(0)
    }

    fun loseHeart(p: Progress, nowMillis: Long): Progress {
        if (p.hearts <= 0) return p
        return p.copy(
            hearts = p.hearts - 1,
            heartsRefillStartMillis = p.heartsRefillStartMillis ?: nowMillis,
        )
    }

    fun gainHeart(p: Progress): Progress {
        val hearts = (p.hearts + 1).coerceAtMost(MAX_HEARTS)
        return p.copy(
            hearts = hearts,
            heartsRefillStartMillis = if (hearts >= MAX_HEARTS) null else p.heartsRefillStartMillis,
        )
    }

    /** Streak shown on screen: it is lost once a whole day passes without a lesson. */
    fun visibleStreak(p: Progress, today: LocalDate): Int {
        val last = p.lastActiveEpochDay ?: return 0
        return if (today.toEpochDay() - last <= 1) p.streak else 0
    }

    fun visibleXpToday(p: Progress, today: LocalDate): Int =
        if (p.xpTodayEpochDay == today.toEpochDay()) p.xpToday else 0

    fun xpForLesson(mistakes: Int, isPractice: Boolean): Int = when {
        isPractice -> XP_PRACTICE
        mistakes == 0 -> XP_PER_LESSON + XP_PERFECT_BONUS
        else -> XP_PER_LESSON
    }

    /**
     * Closes the league week once a new one has started: the top
     * [League.PROMOTION_SLOTS] of the finished week move one tier up.
     * Weeks without any XP don't count and show no result.
     */
    fun rolloverLeague(p: Progress, today: LocalDate): Progress {
        val currentWeek = League.weekStart(today)
        val storedDay = p.leagueWeekStartEpochDay
            ?: return p.copy(leagueWeekStartEpochDay = currentWeek.toEpochDay(), weekXp = 0)
        if (storedDay >= currentWeek.toEpochDay()) return p
        val fresh = p.copy(leagueWeekStartEpochDay = currentWeek.toEpochDay(), weekXp = 0)
        if (p.weekXp <= 0) return fresh
        val rank = League.finalRank(LocalDate.ofEpochDay(storedDay), p.leagueTier, p.weekXp)
        val promotedTo = if (rank <= League.PROMOTION_SLOTS) p.leagueTier.next else null
        return fresh.copy(
            leagueTier = promotedTo ?: p.leagueTier,
            pendingWeekResult = WeekResult(rank, promotedTo),
        )
    }

    fun completeLesson(
        p: Progress,
        lessonId: String,
        mistakes: Int,
        today: LocalDate,
    ): Progress {
        val isPractice = lessonId in p.completedLessons
        val xp = xpForLesson(mistakes, isPractice)
        val day = today.toEpochDay()
        val streak = when (p.lastActiveEpochDay) {
            day -> p.streak
            day - 1 -> p.streak + 1
            else -> 1
        }
        val league = rolloverLeague(p, today)
        val updated = league.copy(
            completedLessons = p.completedLessons + lessonId,
            totalXp = p.totalXp + xp,
            weekXp = league.weekXp + xp,
            streak = streak,
            lastActiveEpochDay = day,
            xpToday = visibleXpToday(p, today) + xp,
            xpTodayEpochDay = day,
        )
        // Practising an old lesson earns a heart back, as in Duolingo.
        return if (isPractice) gainHeart(updated) else updated
    }

    /**
     * Lessons unlock in order: the next one opens once the previous one is done.
     * A finished lesson stays open even if new lessons were added before it.
     */
    fun isUnlocked(course: List<CourseUnit>, lessonId: String, completed: Set<String>): Boolean {
        val ordered = course.flatMap { it.lessons }
        val index = ordered.indexOfFirst { it.id == lessonId }
        if (index < 0) return false
        return index == 0 || lessonId in completed || ordered[index - 1].id in completed
    }

    /** The first lesson that is unlocked but not finished yet, if any. */
    fun currentLessonId(course: List<CourseUnit>, completed: Set<String>): String? =
        course.flatMap { it.lessons }.firstOrNull { it.id !in completed }?.id
}
