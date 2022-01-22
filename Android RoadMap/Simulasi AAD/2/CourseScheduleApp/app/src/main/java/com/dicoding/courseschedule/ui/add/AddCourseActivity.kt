package com.dicoding.courseschedule.ui.add

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.courseschedule.R
import com.dicoding.courseschedule.ui.home.HomeActivity
import com.dicoding.courseschedule.util.DayName.Companion.getByValue
import com.dicoding.courseschedule.util.TimePickerFragment
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

class AddCourseActivity : AppCompatActivity(), TimePickerFragment.DialogTimeListener {
    private lateinit var addTaskViewModel: AddCourseViewModel

    private lateinit var courseNameText: TextInputEditText
    private lateinit var dayText: Spinner
    private lateinit var startTimeText: TextView
    private lateinit var endTimeText: TextView
    private lateinit var lecturerText: TextInputEditText
    private lateinit var noteText: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        supportActionBar?.title = getString(R.string.add_course)
        val factory = AddViewModelFactory.createFactory(this)
        addTaskViewModel =
            ViewModelProvider(this, factory)
                .get(AddCourseViewModel::class.java)

        courseNameText = findViewById(R.id.add_ed_courseName)
        dayText = findViewById(R.id.add_ed_day)
        startTimeText = findViewById(R.id.add_ed_startTime)
        endTimeText = findViewById(R.id.add_ed_endTime)
        lecturerText = findViewById(R.id.add_ed_lecturer)
        noteText = findViewById(R.id.add_ed_note)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return true
    }

    fun showDatePickerStart(view: View) {
        val dialogFragment = TimePickerFragment()
        dialogFragment.show(supportFragmentManager, "start")
    }

    fun showDatePickerEnd(view: View) {
        val dialogFragment = TimePickerFragment()
        dialogFragment.show(supportFragmentManager, "end")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_insert -> {
                val courseName = courseNameText.text.toString()
                val dayName = dayText.selectedItem.toString()
                val day = getByValue(dayName) - 1
                val startTime = startTimeText.text.toString()
                val endTime = endTimeText.text.toString()
                val lecturer = lecturerText.text.toString()
                val note = lecturerText.text.toString()

                addTaskViewModel.insertCourse(
                    courseName = courseName,
                    day = day,
                    startTime = startTime,
                    endTime = endTime,
                    lecturer = lecturer,
                    note = note
                )
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDialogTimeSet(tag: String?, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

        if (tag == "start") {
            startTimeText.text = dateFormat.format(calendar.time)
        } else {
            endTimeText.text = dateFormat.format(calendar.time)
        }
    }


}