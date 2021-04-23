package com.dicoding.moviecatalogue.data

data class MoviesEntity(
        var title: String,
        var date: String,
        var genre: String,
        var duration: String,
        var userScore: Int,
        var overview: String,
        var imagePath: Int
)
