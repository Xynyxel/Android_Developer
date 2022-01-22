package com.dicoding.courseschedule.ui.setting

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.dicoding.courseschedule.R
import com.dicoding.courseschedule.notification.DailyReminder

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        //TODO 10 : Update theme based on value in ListPreference
        val prefTheme = findPreference<ListPreference>(getString(R.string.pref_key_dark))
        prefTheme?.setOnPreferenceChangeListener { preference, newValue ->
            if(newValue == "auto"){
                updateTheme(0)
            }else if(newValue == "off"){
                updateTheme(1)
            }else if(newValue == "on"){
                updateTheme(2)
            }
            true
        }
        //TODO 11 : Schedule and cancel notification in DailyReminder based on SwitchPreference
        val prefNotification =
            findPreference<SwitchPreference>(getString(R.string.pref_key_notify))
        val dailyReminder = DailyReminder()
        prefNotification?.setOnPreferenceChangeListener { preference, newValue ->
            if(newValue.equals(true)){
                dailyReminder.setDailyReminder(requireContext())
            }else{
                dailyReminder.cancelAlarm(requireContext())
            }
            true
        }
    }

    private fun updateTheme(nightMode: Int): Boolean {
        AppCompatDelegate.setDefaultNightMode(nightMode)
        requireActivity().recreate()
        return true
    }
}