package com.dicoding.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.moviecatalogue.data.TvShowEntity
import com.dicoding.moviecatalogue.utils.DataDummy


class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShow()
}