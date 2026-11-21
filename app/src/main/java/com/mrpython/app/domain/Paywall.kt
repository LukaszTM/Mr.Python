package com.mrpython.app.domain

import java.time.LocalDate

/**
 * What the free version holds back until the one-time purchase of the full version.
 * The whole course is free; the free version is limited in pace and comfort instead:
 * one new lesson a day, no XP bonuses, no avatar editing, a hearts limit and ads.
 */
object Paywall {
    /** New lessons a free learner may start per day. Replays and module introductions never count. */
    const val FREE_NEW_LESSONS_PER_DAY = 1

    private fun isIntro(lessonId: String) = lessonId.endsWith("l0")

    /** True when finishing [lessonId] uses up the free learner's new lesson of the day. */
    fun countsTowardsLimit(lessonId: String, completed: Set<String>): Boolean =
        lessonId !in completed && !isIntro(lessonId)

    /** True when a free learner has to wait until tomorrow (or buy) before starting [lessonId]. */
    fun blocksStart(progress: Progress, lessonId: String, today: LocalDate): Boolean =
        countsTowardsLimit(lessonId, progress.completedLessons) &&
            progress.lastNewLessonEpochDay == today.toEpochDay()
}
