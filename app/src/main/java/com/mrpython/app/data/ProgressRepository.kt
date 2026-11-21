package com.mrpython.app.data

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import com.mrpython.app.domain.Accessory
import com.mrpython.app.domain.Avatar
import com.mrpython.app.domain.Avatars
import com.mrpython.app.domain.Boost
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.SnakeSkin
import com.mrpython.app.domain.Rules
import com.mrpython.app.domain.Tier
import com.mrpython.app.domain.WeekResult

/** Stores [Progress] in SharedPreferences. */
class ProgressRepository(context: Context) {

    private val prefs = context.getSharedPreferences("progress", Context.MODE_PRIVATE)

    init {
        // Debug (test) builds unlock the whole avatar wardrobe; release builds keep the promotions.
        Avatars.unlockAll = context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }

    private fun accessory(key: String): Accessory? =
        prefs.getString(key, null)?.let { name -> Accessory.entries.firstOrNull { it.name == name } }

    private fun loadAvatar(): Avatar = Avatar(
        skin = SnakeSkin.entries.firstOrNull { it.name == prefs.getString(KEY_SKIN, null) } ?: SnakeSkin.GREEN,
        head = accessory(KEY_AVATAR_HEAD),
        eyes = accessory(KEY_AVATAR_EYES),
        extra = accessory(KEY_AVATAR_EXTRA),
    )

    fun load(): Progress = Progress(
        completedLessons = prefs.getStringSet(KEY_COMPLETED, emptySet())!!.toSet(),
        totalXp = prefs.getInt(KEY_XP, 0),
        hearts = prefs.getInt(KEY_HEARTS, Rules.MAX_HEARTS),
        heartsRefillStartMillis = prefs.getLongOrNull(KEY_REFILL_START),
        streak = prefs.getInt(KEY_STREAK, 0),
        lastActiveEpochDay = prefs.getLongOrNull(KEY_LAST_ACTIVE),
        xpToday = prefs.getInt(KEY_XP_TODAY, 0),
        xpTodayEpochDay = prefs.getLongOrNull(KEY_XP_TODAY_DAY),
        leagueTier = Tier.entries.getOrElse(prefs.getInt(KEY_TIER, 0)) { Tier.INTERN },
        leagueWeekStartEpochDay = prefs.getLongOrNull(KEY_WEEK_START),
        weekXp = prefs.getInt(KEY_WEEK_XP, 0),
        pendingWeekResult = if (prefs.contains(KEY_RESULT_RANK)) {
            WeekResult(
                rank = prefs.getInt(KEY_RESULT_RANK, 0),
                promotedTo = Tier.entries.getOrNull(prefs.getInt(KEY_RESULT_TIER, -1)),
            )
        } else {
            null
        },
        lastNewLessonEpochDay = prefs.getLongOrNull(KEY_LAST_NEW_LESSON),
        boost = prefs.getString(KEY_BOOST_TITLE, null)?.let { title ->
            Boost(title, prefs.getInt(KEY_BOOST_PERCENT, 100), prefs.getLong(KEY_BOOST_UNTIL, 0))
        },
    ).let { it.copy(avatar = Avatars.sanitize(loadAvatar(), it.leagueTier)) }

    fun save(p: Progress) {
        val editor = prefs.edit()
            .putStringSet(KEY_COMPLETED, p.completedLessons)
            .putInt(KEY_XP, p.totalXp)
            .putInt(KEY_HEARTS, p.hearts)
            .putLongOrRemove(KEY_REFILL_START, p.heartsRefillStartMillis)
            .putInt(KEY_STREAK, p.streak)
            .putLongOrRemove(KEY_LAST_ACTIVE, p.lastActiveEpochDay)
            .putInt(KEY_XP_TODAY, p.xpToday)
            .putLongOrRemove(KEY_XP_TODAY_DAY, p.xpTodayEpochDay)
            .putInt(KEY_TIER, p.leagueTier.ordinal)
            .putLongOrRemove(KEY_WEEK_START, p.leagueWeekStartEpochDay)
            .putInt(KEY_WEEK_XP, p.weekXp)
            .putString(KEY_SKIN, p.avatar.skin.name)
            .putString(KEY_AVATAR_HEAD, p.avatar.head?.name)
            .putString(KEY_AVATAR_EYES, p.avatar.eyes?.name)
            .putString(KEY_AVATAR_EXTRA, p.avatar.extra?.name)
            .putString(KEY_BOOST_TITLE, p.boost?.title)
            .putLongOrRemove(KEY_LAST_NEW_LESSON, p.lastNewLessonEpochDay)
            .putInt(KEY_BOOST_PERCENT, p.boost?.percent ?: 100)
            .putLong(KEY_BOOST_UNTIL, p.boost?.untilMillis ?: 0)
        val result = p.pendingWeekResult
        if (result == null) {
            editor.remove(KEY_RESULT_RANK).remove(KEY_RESULT_TIER)
        } else {
            editor.putInt(KEY_RESULT_RANK, result.rank).putInt(KEY_RESULT_TIER, result.promotedTo?.ordinal ?: -1)
        }
        editor.apply()
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
        const val KEY_TIER = "league_tier"
        const val KEY_WEEK_START = "league_week_start"
        const val KEY_WEEK_XP = "league_week_xp"
        const val KEY_RESULT_RANK = "league_result_rank"
        const val KEY_RESULT_TIER = "league_result_tier"
        const val KEY_SKIN = "avatar_skin"
        const val KEY_AVATAR_HEAD = "avatar_head"
        const val KEY_AVATAR_EYES = "avatar_eyes"
        const val KEY_AVATAR_EXTRA = "avatar_extra"
        const val KEY_BOOST_TITLE = "boost_title"
        const val KEY_LAST_NEW_LESSON = "last_new_lesson_day"
        const val KEY_BOOST_PERCENT = "boost_percent"
        const val KEY_BOOST_UNTIL = "boost_until"
    }
}
