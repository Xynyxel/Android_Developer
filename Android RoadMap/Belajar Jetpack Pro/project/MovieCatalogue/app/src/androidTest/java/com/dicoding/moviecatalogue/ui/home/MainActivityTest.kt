package com.dicoding.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummymovie = DataDummy.generateDummyMovies()
    private val dummytvshow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_Movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_Movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummymovie.size
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_TvShow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_TvShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummytvshow.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_Movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.txt_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_title))
            .check(ViewAssertions.matches(withText(dummymovie[0].title)))
        onView(withId(R.id.txt_date))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_date))
            .check(ViewAssertions.matches(withText(dummymovie[0].date)))
        onView(withId(R.id.txt_duration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_duration))
            .check(ViewAssertions.matches(withText(dummymovie[0].duration)))
        onView(withId(R.id.txt_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_genre))
            .check(ViewAssertions.matches(withText(dummymovie[0].genre)))
        onView(withId(R.id.txt_overview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_overview))
            .check(
                ViewAssertions.matches(
                    withText(
                        "Overview\n" +
                                "\n" + dummymovie[0].overview
                    )
                )
            )
        onView(withId(R.id.txt_userScore))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_userScore))
            .check(ViewAssertions.matches(withText(dummymovie[0].userScore.toString() + "%")))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_TvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.txt_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_title))
            .check(ViewAssertions.matches(withText(dummytvshow[0].title)))
        onView(withId(R.id.txt_date))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_date))
            .check(ViewAssertions.matches(withText(dummytvshow[0].date)))
        onView(withId(R.id.txt_duration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_duration))
            .check(ViewAssertions.matches(withText(dummytvshow[0].duration)))
        onView(withId(R.id.txt_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_genre))
            .check(ViewAssertions.matches(withText(dummytvshow[0].genre)))
        onView(withId(R.id.txt_overview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_overview))
            .check(
                ViewAssertions.matches(
                    withText(
                        "Overview\n" +
                                "\n" + dummytvshow[0].overview
                    )
                )
            )
        onView(withId(R.id.txt_userScore))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.txt_userScore))
            .check(ViewAssertions.matches(withText(dummytvshow[0].userScore.toString() + "%")))
    }
}