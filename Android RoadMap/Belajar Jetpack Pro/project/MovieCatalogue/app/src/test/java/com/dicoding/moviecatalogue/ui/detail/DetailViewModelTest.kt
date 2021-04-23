package com.dicoding.moviecatalogue.ui.detail

import com.dicoding.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummytvshow = DataDummy.generateDummyTvShow()[0]
    private val dummymovie = DataDummy.generateDummyMovies()[0]
    private val tvshowtitle = dummytvshow.title
    private val movietitle = dummymovie.title

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedTvShow(tvshowtitle)
        viewModel.setSelectedMovie(movietitle)
    }

    @Test
    fun gettvshow() {
        viewModel.setSelectedTvShow(dummytvshow.title)
        val tvshowEntity = viewModel.getTvShow()
        assertNotNull(tvshowEntity)
        assertEquals(dummytvshow.title, tvshowEntity.title)
        assertEquals(dummytvshow.date, tvshowEntity.date)
        assertEquals(dummytvshow.duration, tvshowEntity.duration)
        assertEquals(dummytvshow.genre, tvshowEntity.genre)
        assertEquals(dummytvshow.imagePath, tvshowEntity.imagePath)
        assertEquals(dummytvshow.userScore, tvshowEntity.userScore)
        assertEquals(dummytvshow.overview, tvshowEntity.overview)
    }

    @Test
    fun getmovie() {
        viewModel.setSelectedMovie(dummymovie.title)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummymovie.title, movieEntity.title)
        assertEquals(dummymovie.date, movieEntity.date)
        assertEquals(dummymovie.duration, movieEntity.duration)
        assertEquals(dummymovie.genre, movieEntity.genre)
        assertEquals(dummymovie.imagePath, movieEntity.imagePath)
        assertEquals(dummymovie.userScore, movieEntity.userScore)
        assertEquals(dummymovie.overview, movieEntity.overview)
    }


}