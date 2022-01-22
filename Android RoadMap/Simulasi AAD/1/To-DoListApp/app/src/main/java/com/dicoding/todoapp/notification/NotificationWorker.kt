package com.dicoding.todoapp.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.dicoding.todoapp.R
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.data.TaskRepository
import com.dicoding.todoapp.ui.detail.DetailTaskActivity
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.NOTIFICATION_CHANNEL_ID
import com.dicoding.todoapp.utils.TASK_ID

class NotificationWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    private val channelName = inputData.getString(NOTIFICATION_CHANNEL_ID)

    private fun getPendingIntent(task: Task): PendingIntent? {
        val intent = Intent(applicationContext, DetailTaskActivity::class.java).apply {
            putExtra(TASK_ID, task.id)
        }
        return TaskStackBuilder.create(applicationContext).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

    override fun doWork(): Result {
        //TODO 14 : If notification preference on, get nearest active task from repository and show notification with pending intent

        val taskNearest = Task(
                inputData.getInt(ID, 0),
                inputData.getString(TITLE).toString(),
                inputData.getString(DESCRIPTION).toString(),
                inputData.getLong(DUEDATE, 0L),
                inputData.getBoolean(COMPLETE, false),
        )

        val channelID = NOTIFICATION_CHANNEL_ID

        val pendingIntent = getPendingIntent(taskNearest)
        val mNotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(applicationContext, channelID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(taskNearest.title)
                .setContentText(applicationContext.getString(
                        R.string.notify_content,
                        DateConverter.convertMillisToString(taskNearest.dueDateMillis)
                ))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = channelName

            notification.setChannelId(channelID)
            mNotificationManager.createNotificationChannel(channel)
        }
        mNotificationManager.notify(1, notification.build())
        return Result.success()
    }

    companion object {
        const val ID = "ID"
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
        const val DUEDATE = "DUEDATE"
        const val COMPLETE = "COMPLETE"
    }



}
