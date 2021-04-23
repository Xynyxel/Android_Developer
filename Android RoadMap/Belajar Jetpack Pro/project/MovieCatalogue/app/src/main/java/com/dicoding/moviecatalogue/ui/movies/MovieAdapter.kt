package com.dicoding.moviecatalogue.ui.movies

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.MoviesEntity
import com.dicoding.moviecatalogue.databinding.ItemPosterBinding
import com.dicoding.moviecatalogue.ui.detail.DetailMoviesActivity


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.PosterViewHolder>() {
    private var listMovies = ArrayList<MoviesEntity>()

    inner class PosterViewHolder(private val binding: ItemPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movies.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                txtTitle.text = movies.title
                txtDate.text = movies.date
                txtGenre.text = movies.genre
                txtDuration.text = movies.duration
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                intent.putExtra(DetailMoviesActivity.EXTRA_MOVIE_TITLE, movies.title)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    itemView.context as Activity
                )
                itemView.context.startActivity(intent, options.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val itemPosterBinding = ItemPosterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PosterViewHolder(itemPosterBinding)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    fun setMovies(movies: List<MoviesEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
}