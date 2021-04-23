package com.dicoding.moviecatalogue.ui.movies


import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getCourses() {
        val moviewEntities = viewModel.getMovies()
        assertNotNull(moviewEntities)
        assertEquals(10, moviewEntities.size)
    }


}