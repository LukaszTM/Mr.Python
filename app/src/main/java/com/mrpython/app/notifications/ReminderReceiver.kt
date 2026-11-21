package com.mrpython.app.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mrpython.app.domain.ReminderKind
import com.mrpython.app.widget.StreakWidget

/**
 * Fires when a reminder alarm goes off, and after a reboot or an app update
 * (alarms are lost then). Each run schedules the next day's alarms.
 */
class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val kind = intent.getStringExtra(ReminderScheduler.EXTRA_KIND)
            ?.let { name -> ReminderKind.entries.firstOrNull { it.name == name } }
        if (kind != null) ReminderScheduler.show(context, kind)
        ReminderScheduler.schedule(context)
        StreakWidget.refresh(context)
    }
}
