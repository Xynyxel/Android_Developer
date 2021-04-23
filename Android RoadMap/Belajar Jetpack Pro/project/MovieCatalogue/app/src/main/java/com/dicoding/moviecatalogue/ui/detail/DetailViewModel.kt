package com.dicoding.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.MoviesEntity
import com.dicoding.moviecatalogue.data.TvShowEntity
import com.dicoding.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var titleMovie: String
    private lateinit var titleTvShow: String

    fun setSelectedMovie(titleMovie: String) {
        this.titleMovie = titleMovie
    }

    fun setSelectedTvShow(titleTvShow: String) {
        this.titleTvShow = titleTvShow
    }

    fun getMovie(): MoviesEntity {
        lateinit var movie: MoviesEntity
        val movieEntities = DataDummy.generateDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.title == titleMovie) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvshow: TvShowEntity
        val tvShowEntities = DataDummy.generateDummyTvShow()
        for (tvshowEntity in tvShowEntities) {
            if (tvshowEntity.title == titleTvShow) {
                tvshow = tvshowEntity
            }
        }
        return tvshow
    }

}