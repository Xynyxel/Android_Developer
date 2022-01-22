package com.dicoding.courseschedule.ui.home

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.courseschedule.R
import junit.framework.TestCase

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun validateAddTaskActivity() {
        Espresso.onView(withId(R.id.action_add)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.action_add)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.add_ed_courseName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.add_ed_day))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.add_btn_startTime))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.add_btn_endTime))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.add_ed_lecturer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.add_ed_note))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}