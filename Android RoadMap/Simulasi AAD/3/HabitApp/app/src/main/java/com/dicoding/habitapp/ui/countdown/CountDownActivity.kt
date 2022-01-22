package com.dicoding.habitapp.ui.countdown

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.work.Data
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.dicoding.habitapp.R
import com.dicoding.habitapp.data.Habit
import com.dicoding.habitapp.notification.NotificationWorker
import com.dicoding.habitapp.utils.HABIT
import com.dicoding.habitapp.utils.HABIT_ID
import com.dicoding.habitapp.utils.HABIT_TITLE
import com.dicoding.habitapp.utils.NOTIFICATION_CHANNEL_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class CountDownActivity : AppCompatActivity() {
    private lateinit var workManager: WorkManager
    private lateinit var periodictask: PeriodicWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)
        supportActionBar?.title = "Count Down"

        val habit = intent.getParcelableExtra<Habit>(HABIT) as Habit

        findViewById<TextView>(R.id.tv_count_down_title).text = habit.title
        findViewById<TextView>(R.id.tv_count_down).text = habit.minutesFocus.toString() + ":00"

        val viewModel = ViewModelProvider(this).get(CountDownViewModel::class.java)

        //TODO 10 : Set initial time and observe current time. Update button state when countdown is finished
        viewModel.setInitialTime(habit.minutesFocus)
        //TODO 13 : Start and cancel One Time Request WorkManager to notify when time is up.

        val channelName = getString(R.string.notify_channel_name)
        lifecycleScope.launch(Dispatchers.IO){
            val habitCountDown = Data.Builder()
                .putString(NOTIFICATION_CHANNEL_ID, channelName)
                .putInt(HABIT_ID, habit.id)
                .putString(HABIT_TITLE, habit.title)
                .build()
            workManager = WorkManager.getInstance(applicationContext)
            periodictask = PeriodicWorkRequest.Builder(NotificationWorker::class.java,
                1, TimeUnit.DAYS)
                .setInputData(habitCountDown)
                .addTag(channelName)
                .build()
        }

        findViewById<Button>(R.id.btn_start).setOnClickListener {
            viewModel.startTimer()
            lifecycleScope.launch {
                viewModel.currentTimeString.observe(this@CountDownActivity, {
                    findViewById<TextView>(R.id.tv_count_down).text = it
                })
            }
            updateButtonState(true)
        }

        findViewById<Button>(R.id.btn_stop).setOnClickListener {
            viewModel.resetTimer()
            updateButtonState(false)
            workManager.cancelWorkById(periodictask.id)
        }

        viewModel.eventCountDownFinish.observe(this@CountDownActivity, {
            if(it == true){
                workManager.enqueue(periodictask)
                updateButtonState(false)
            }
        })
    }

    private fun updateButtonState(isRunning: Boolean) {
        findViewById<Button>(R.id.btn_start).isEnabled = !isRunning
        findViewById<Button>(R.id.btn_stop).isEnabled = isRunning
    }

}