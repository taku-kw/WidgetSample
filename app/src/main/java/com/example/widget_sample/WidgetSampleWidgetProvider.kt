package com.example.widget_sample

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class WidgetSampleWidgetProvider : AppWidgetProvider() {

    private val text = "Hello Widget World!"
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        val pendingIntent: PendingIntent = Intent(context, MainActivity::class.java)
            .let { intent ->
                PendingIntent.getActivity(context, 0, intent, 0)
            }

        appWidgetIds?.forEach {id ->
            val views: RemoteViews = RemoteViews(
                context?.packageName,
                R.layout.widget_sample_widget
            ).apply {
                setOnClickPendingIntent(R.id.textView, pendingIntent)
            }

            appWidgetManager?.updateAppWidget(id, views)
        }
    }
}