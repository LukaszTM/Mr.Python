package com.mrpython.app.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.mrpython.app.MainActivity
import com.mrpython.app.R
import com.mrpython.app.data.ProgressRepository
import com.mrpython.app.domain.Moods
import com.mrpython.app.domain.SnakeMood
import com.mrpython.app.ui.components.snakeImage
import java.time.LocalDateTime

/**
 * Home screen widget: the learner's snake, the streak and a line that changes with the
 * snake's mood. The system refreshes it every half an hour; the app also refreshes it
 * whenever progress changes and when a reminder alarm fires.
 */
class StreakWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        ids.forEach { manager.updateAppWidget(it, views(context)) }
    }

    companion object {
        /** Redraws every placed widget; does nothing when there is none. */
        fun refresh(context: Context) {
            val manager = AppWidgetManager.getInstance(context) ?: return
            val ids = manager.getAppWidgetIds(ComponentName(context, StreakWidget::class.java))
            if (ids.isNotEmpty()) manager.updateAppWidget(ids, views(context))
        }

        private fun views(context: Context): RemoteViews {
            val progress = ProgressRepository(context).load()
            val state = Moods.state(progress, LocalDateTime.now())
            val open = PendingIntent.getActivity(
                context,
                0,
                Intent(context, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
            return RemoteViews(context.packageName, R.layout.widget_streak).apply {
                // Until each mood has its own picture, the learner's snake is shown as it is.
                setImageViewResource(R.id.widget_snake, snakeImage(progress.avatar.skin))
                setTextViewText(R.id.widget_streak, "${icon(state.mood)} ${Moods.days(state.streak)}")
                setTextViewText(R.id.widget_text, state.text)
                setOnClickPendingIntent(R.id.widget_root, open)
            }
        }

        private fun icon(mood: SnakeMood): String = when (mood) {
            SnakeMood.HAPPY -> "🔥"
            SnakeMood.BORED -> "💤"
            SnakeMood.WORRIED -> "⏳"
            SnakeMood.SAD -> "💔"
        }
    }
}
