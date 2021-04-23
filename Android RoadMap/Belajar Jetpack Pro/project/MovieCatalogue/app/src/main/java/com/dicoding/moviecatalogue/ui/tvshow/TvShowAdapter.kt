package com.dicoding.moviecatalogue.ui.tvshow

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.TvShowEntity
import com.dicoding.moviecatalogue.databinding.ItemPosterBinding
import com.dicoding.moviecatalogue.ui.detail.DetailTvShowActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.PosterViewHolder>() {
    private var listTvShow = ArrayList<TvShowEntity>()

    inner class PosterViewHolder(private val binding: ItemPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(tvShow.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                txtTitle.text = tvShow.title
                txtDate.text = tvShow.date
                txtGenre.text = tvShow.genre
                txtDuration.text = tvShow.duration
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW_TITLE, tvShow.title)
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity
                    )
                    itemView.context.startActivity(intent, options.toBundle())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val itemPosterBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosterViewHolder(itemPosterBinding)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val movie = listTvShow[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listTvShow.size

    fun setTvShow(TvShow: List<TvShowEntity>?) {
        if (TvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(TvShow)
    }
}