package com.dicoding.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.MoviesEntity
import com.dicoding.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(): List<MoviesEntity> = DataDummy.generateDummyMovies()
}