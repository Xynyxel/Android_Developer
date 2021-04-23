package com.dicoding.moviecatalogue.ui.tvshow

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getCourses() {
        val tvshowEntities = viewModel.getTvShow()
        assertNotNull(tvshowEntities)
        assertEquals(11, tvshowEntities.size)
    }
}