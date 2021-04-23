package com.dicoding.moviecatalogue.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.moviecatalogue.databinding.ActivityDetailMoviesBinding

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE_TITLE = "extra_movie_title"
    }

    private lateinit var activityDetailMoviesBinding: ActivityDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(activityDetailMoviesBinding.root)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val movieTitle = intent.getStringExtra(EXTRA_MOVIE_TITLE)

        if (movieTitle != null) {
            viewModel.setSelectedMovie(movieTitle)
            val movie = viewModel.getMovie()
            with(activityDetailMoviesBinding) {
                txtTitle.text = movie.title
                txtDate.text = movie.date
                txtGenre.text = movie.genre
                txtOverview.text = "Overview\n\n" + movie.overview
                txtDuration.text = movie.duration
                txtUserScore.text = movie.userScore.toString() + "%"
                pgUserScore.progress = movie.userScore
                Glide.with(this@DetailMoviesActivity)
                    .load(movie.imagePath)
                    .apply(
                        com.bumptech.glide.request.RequestOptions.placeholderOf(com.dicoding.moviecatalogue.R.drawable.ic_loading)
                            .error(com.dicoding.moviecatalogue.R.drawable.ic_error)
                    )
                    .into(imagedtMovie)
                ftBack.setOnClickListener {
                    val intent = Intent(
                        this@DetailMoviesActivity,
                        com.dicoding.moviecatalogue.ui.home.MainActivity::class.java
                    )
                    startActivity(intent)
                }
            }
        }
    }
}