package com.dicoding.moviecatalogue.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.dicoding.moviecatalogue.ui.home.MainActivity

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW_TITLE = "extra_tvshow_title"
    }


    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(activityDetailTvShowBinding.root)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val tvShowTitle = intent.getStringExtra(EXTRA_TVSHOW_TITLE)
        if (tvShowTitle != null) {
            viewModel.setSelectedTvShow(tvShowTitle)
            val tvShow = viewModel.getTvShow()
            with(activityDetailTvShowBinding) {
                txtTitle.text = tvShow.title
                txtDate.text = tvShow.date
                txtGenre.text = tvShow.genre
                txtOverview.text = resources.getString(
                    R.string.overview,
                    tvShow.overview
                )

                txtDuration.text = tvShow.duration
                txtUserScore.text = resources.getString(
                    R.string.user_score_percent,
                    tvShow.userScore.toString()
                )
                pgUserScore.progress = tvShow.userScore
                Glide.with(this@DetailTvShowActivity)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imagedtTvshow)
                ftBack.setOnClickListener {
                    val intent = Intent(this@DetailTvShowActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}