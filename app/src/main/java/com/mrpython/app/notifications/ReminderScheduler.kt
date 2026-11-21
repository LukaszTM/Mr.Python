package com.mrpython.app.notifications

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.mrpython.app.MainActivity
import com.mrpython.app.R
import com.mrpython.app.data.ProgressRepository
import com.mrpython.app.data.SettingsRepository
import com.mrpython.app.domain.ReminderKind
import com.mrpython.app.domain.Reminders
import com.mrpython.app.domain.t
import java.time.LocalDateTime
import java.time.ZoneId

/** Schedules and shows lesson reminders with AlarmManager; no background service needed. */
object ReminderScheduler {
    const val EXTRA_KIND = "kind"
    private const val ACTION_REMIND = "com.mrpython.app.REMIND"
    private const val CHANNEL_ID = "lesson_reminders"

    /** (Re)schedules the next reminders according to the settings. Safe to call often. */
    fun schedule(context: Context) {
        val settings = SettingsRepository(context)
        val alarms = context.getSystemService(AlarmManager::class.java) ?: return
        for (kind in ReminderKind.entries) {
            val intent = alarmIntent(context, kind)
            alarms.cancel(intent)
            val hour = when (kind) {
                ReminderKind.DAILY -> settings.reminderHour
                ReminderKind.STREAK_RESCUE -> Reminders.STREAK_RESCUE_HOUR
            }
            // No separate rescue when the daily reminder is already that late.
            val redundant = kind == ReminderKind.STREAK_RESCUE && settings.reminderHour >= hour
            if (!settings.remindersEnabled || redundant) continue
            alarms.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, nextOccurrenceMillis(hour), intent)
        }
    }

    private fun nextOccurrenceMillis(hour: Int): Long {
        val now = LocalDateTime.now()
        var next = now.toLocalDate().atTime(hour, 0)
        if (!next.isAfter(now)) next = next.plusDays(1)
        return next.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }

    private fun alarmIntent(context: Context, kind: ReminderKind): PendingIntent {
        val intent = Intent(context, ReminderReceiver::class.java)
            .setAction(ACTION_REMIND)
            .putExtra(EXTRA_KIND, kind.name)
        return PendingIntent.getBroadcast(
            context,
            kind.ordinal,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
    }

    fun canNotify(context: Context): Boolean {
        val manager = context.getSystemService(NotificationManager::class.java) ?: return false
        val granted = Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) ==
            PackageManager.PERMISSION_GRANTED
        return granted && manager.areNotificationsEnabled()
    }

    /** Shows the reminder of the given [kind], unless today's lesson is already done. */
    fun show(context: Context, kind: ReminderKind) {
        if (!SettingsRepository(context).remindersEnabled || !canNotify(context)) return
        val progress = ProgressRepository(context).load()
        val message = Reminders.message(progress, kind, LocalDateTime.now()) ?: return
        val manager = context.getSystemService(NotificationManager::class.java) ?: return
        manager.createNotificationChannel(
            NotificationChannel(CHANNEL_ID, "Przypomnienia o lekcji".t(), NotificationManager.IMPORTANCE_DEFAULT)
                .apply { description = "Codzienne przypomnienie o nauce i ostrzeżenie o utracie serii".t() }
        )
        val openApp = PendingIntent.getActivity(
            context,
            0,
            Intent(context, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setColor(0xFFFFD43B.toInt())
            .setContentTitle(message.title)
            .setContentText(message.text)
            .setStyle(NotificationCompat.BigTextStyle().bigText(message.text))
            .setContentIntent(openApp)
            .setAutoCancel(true)
            .build()
        manager.notify(NOTIFICATION_ID, notification)
    }

    /** Removes a reminder that is still on screen, e.g. after the lesson was done. */
    fun clearShown(context: Context) {
        context.getSystemService(NotificationManager::class.java)?.cancel(NOTIFICATION_ID)
    }

    private const val NOTIFICATION_ID = 1
}
