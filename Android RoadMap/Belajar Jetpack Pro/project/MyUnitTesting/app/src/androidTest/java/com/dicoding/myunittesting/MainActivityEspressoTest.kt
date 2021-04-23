package com.dicoding.myunittesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEspressoTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertGetCircumference() {
        inputtest()
        savetest()

        // btn calculate circumference
        onView(withId(R.id.btn_calculate_circumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_circumference)).perform(click())

        resulttest(dummyCircumference)
    }

    @Test
    fun assertGetSurfaceArea() {
        inputtest()
        savetest()

        // btn surface area
        onView(withId(R.id.btn_calculate_surface_area)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_surface_area)).perform(click())

        resulttest(dummySurfaceArea)
    }

    @Test
    fun assertGetVolume() {
        inputtest()
        savetest()

        //btn calculate volume
        onView(withId(R.id.btn_calculate_volume)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_volume)).perform(click())

        resulttest(dummyVolume)
    }
    //Pengecekan untuk empty input
    @Test
    fun assertEmptyInput() {

        // pengecekan input untuk length
        onView(withId(R.id.edt_length)).perform(typeText(emptyInput), closeSoftKeyboard())
        savetest()
        onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())

        // pengecekan input untuk width
        onView(withId(R.id.edt_width)).perform(typeText(emptyInput), closeSoftKeyboard())
        savetest()
        onView(withId(R.id.edt_width)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())

        // pengecekan input untuk height
        onView(withId(R.id.edt_height)).perform(typeText(emptyInput), closeSoftKeyboard())
        savetest()
        onView(withId(R.id.edt_height)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        savetest()
    }

    fun inputtest(){
        // input
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())
    }

    fun savetest(){
        // btn save
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
    }

    fun resulttest(dummyValue: String){
        //btn tv result
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(dummyValue)))
    }

}