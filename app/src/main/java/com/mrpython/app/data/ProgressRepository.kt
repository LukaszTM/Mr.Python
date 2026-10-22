package com.mrpython.app.data

import android.content.Context
import android.content.SharedPreferences
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.Rules

/** Stores [Progress] in SharedPreferences. */
class ProgressRepository(context: Context) {

    private val prefs = context.getSharedPreferences("progress", Context.MODE_PRIVATE)

    fun load(): Progress = Progress(
        completedLessons = prefs.getStringSet(KEY_COMPLETED, emptySet())!!.toSet(),
        totalXp = prefs.getInt(KEY_XP, 0),
        hearts = prefs.getInt(KEY_HEARTS, Rules.MAX_HEARTS),
        heartsRefillStartMillis = prefs.getLongOrNull(KEY_REFILL_START),
        streak = prefs.getInt(KEY_STREAK, 0),
        lastActiveEpochDay = prefs.getLongOrNull(KEY_LAST_ACTIVE),
        xpToday = prefs.getInt(KEY_XP_TODAY, 0),
        xpTodayEpochDay = prefs.getLongOrNull(KEY_XP_TODAY_DAY),
    )

    fun save(p: Progress) {
        prefs.edit()
            .putStringSet(KEY_COMPLETED, p.completedLessons)
            .putInt(KEY_XP, p.totalXp)
            .putInt(KEY_HEARTS, p.hearts)
            .putLongOrRemove(KEY_REFILL_START, p.heartsRefillStartMillis)
            .putInt(KEY_STREAK, p.streak)
            .putLongOrRemove(KEY_LAST_ACTIVE, p.lastActiveEpochDay)
            .putInt(KEY_XP_TODAY, p.xpToday)
            .putLongOrRemove(KEY_XP_TODAY_DAY, p.xpTodayEpochDay)
            .apply()
    }

    fun reset() {
        prefs.edit().clear().apply()
    }

    private fun SharedPreferences.getLongOrNull(key: String): Long? =
        if (contains(key)) getLong(key, 0) else null

    private fun SharedPreferences.Editor.putLongOrRemove(key: String, value: Long?) =
        if (value == null) remove(key) else putLong(key, value)

    private companion object {
        const val KEY_COMPLETED = "completed_lessons"
        const val KEY_XP = "total_xp"
        const val KEY_HEARTS = "hearts"
        const val KEY_REFILL_START = "hearts_refill_start"
        const val KEY_STREAK = "streak"
        const val KEY_LAST_ACTIVE = "last_active_day"
        const val KEY_XP_TODAY = "xp_today"
        const val KEY_XP_TODAY_DAY = "xp_today_day"
    }
}
