package com.dicoding.todoapp.setting

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import androidx.work.Data
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.dicoding.todoapp.R
import com.dicoding.todoapp.notification.NotificationWorker
import com.dicoding.todoapp.notification.NotificationWorker.Companion.DUEDATE
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.NOTIFICATION_CHANNEL_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.settings, SettingsFragment())
                    .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            val prefNotification = findPreference<SwitchPreference>(getString(R.string.pref_key_notify))
            prefNotification?.setOnPreferenceChangeListener { preference, newValue ->
                val channelName = getString(R.string.notify_channel_name)
                val factory = ViewModelFactory.getInstance(context as Context)
                val nearestTaskViewModel =
                        ViewModelProvider(this, factory)
                                .get(NearestTaskViewModel::class.java)
                //TODO 13 : Schedule and cancel daily reminder using WorkManager with data channelName
                lifecycleScope.launch(Dispatchers.IO) {
                    val nearestTask = nearestTaskViewModel.nearestTask()
                    val dataNearestTask = Data.Builder()
                            .putString(NOTIFICATION_CHANNEL_ID, channelName)
                            .putInt(NotificationWorker.ID, nearestTask.id)
                            .putString(NotificationWorker.TITLE, nearestTask.title)
                            .putString(NotificationWorker.DESCRIPTION, nearestTask.description)
                            .putLong(DUEDATE, nearestTask.dueDateMillis)
                            .putBoolean(NotificationWorker.COMPLETE, nearestTask.isCompleted)
                            .build()
                    val workManager = WorkManager.getInstance(context as Context)
                    val periodicWork = PeriodicWorkRequest.Builder(NotificationWorker::class.java,
                            1, TimeUnit.DAYS)
                            .setInputData(dataNearestTask)
                            .addTag(channelName)
                            .build()
                    if (newValue.equals(true)) {
                        workManager.enqueue(periodicWork)
                    } else {
                        workManager.cancelWorkById(periodicWork.id)
                    }
                }
                true
            }

        }

        private fun updateTheme(mode: Int): Boolean {
            AppCompatDelegate.setDefaultNightMode(mode)
            requireActivity().recreate()
            return true
        }

        fun isAlarmSet(context: Context): Boolean {
            val intent = Intent(context, NotificationWorker::class.java)
            return PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_NO_CREATE) != null
        }


    }
}