package com.mrpython.app.data

import android.content.Context
import com.mrpython.app.domain.Reminders

/** App settings that are not part of the learning progress. */
class SettingsRepository(context: Context) {

    private val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    var remindersEnabled: Boolean
        get() = prefs.getBoolean(KEY_REMINDERS, true)
        set(value) = prefs.edit().putBoolean(KEY_REMINDERS, value).apply()

    /** Hour of the day (0-23) of the daily lesson reminder. */
    var reminderHour: Int
        get() = prefs.getInt(KEY_HOUR, Reminders.DEFAULT_HOUR)
        set(value) = prefs.edit().putInt(KEY_HOUR, value).apply()

    /** Whether the system notification permission dialog has already been shown. */
    var notificationPermissionAsked: Boolean
        get() = prefs.getBoolean(KEY_ASKED, false)
        set(value) = prefs.edit().putBoolean(KEY_ASKED, value).apply()

    /** Cached answer of Google Play, so the full course also opens without a connection. */
    var fullCourse: Boolean
        get() = prefs.getBoolean(KEY_FULL_COURSE, false)
        set(value) = prefs.edit().putBoolean(KEY_FULL_COURSE, value).apply()

    /** The welcome XP bonus is handed out once, on the first launch. */
    var welcomeBoostGiven: Boolean
        get() = prefs.getBoolean(KEY_WELCOME_BOOST, false)
        set(value) = prefs.edit().putBoolean(KEY_WELCOME_BOOST, value).apply()

    private companion object {
        const val KEY_WELCOME_BOOST = "welcome_boost_given"
        const val KEY_FULL_COURSE = "full_course"
        const val KEY_REMINDERS = "reminders_enabled"
        const val KEY_HOUR = "reminder_hour"
        const val KEY_ASKED = "notification_permission_asked"
    }
}
