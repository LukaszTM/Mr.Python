package com.mrpython.app.data

import android.content.Context
import com.mrpython.app.domain.I18n
import com.mrpython.app.domain.Language
import com.mrpython.app.domain.Reminders
import java.util.Locale

/** App settings that are not part of the learning progress. */
class SettingsRepository(context: Context) {

    private val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    init {
        // Every entry point of the app (screen, reminder, widget) reads its settings first,
        // so this is where the language of all texts gets switched on.
        I18n.language = language
    }

    /** The chosen language; until the learner picks one, it follows the phone's language. */
    var language: Language
        get() = prefs.getString(KEY_LANGUAGE, null)?.let { code -> Language.entries.firstOrNull { it.code == code } }
            ?: I18n.forLocale(Locale.getDefault().toLanguageTag())
        set(value) {
            prefs.edit().putString(KEY_LANGUAGE, value.code).apply()
            I18n.language = value
        }

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
        const val KEY_LANGUAGE = "language"
        const val KEY_WELCOME_BOOST = "welcome_boost_given"
        const val KEY_FULL_COURSE = "full_course"
        const val KEY_REMINDERS = "reminders_enabled"
        const val KEY_HOUR = "reminder_hour"
        const val KEY_ASKED = "notification_permission_asked"
    }
}
