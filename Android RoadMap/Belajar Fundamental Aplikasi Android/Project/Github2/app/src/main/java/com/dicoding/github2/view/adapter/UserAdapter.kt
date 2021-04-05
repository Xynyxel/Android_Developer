package com.dicoding.github2.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.github2.R
import com.dicoding.github2.view.activity.DetailUserActivity
import com.dicoding.github2.model.User
import com.dicoding.github2.databinding.ActivityItemUserBinding
import maes.tech.intentanim.CustomIntent

class UserAdapter : RecyclerView.Adapter<UserAdapter.ListViewHolder>()  {
    private val listUser = ArrayList<User>()

    fun setData(items: ArrayList<User>) {
        listUser.clear()
        listUser.addAll(items)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ActivityItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            Glide.with(itemView.context)
                .load(user.Avatar)
                .apply(RequestOptions().override(200, 200))
                .into(binding.imageAvatar)
            binding.layoutItemUser.setBackgroundResource(R.drawable.card_background)
            binding.tvUsername.text = user.Username

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.EXTRA_USER, user.Username)
                itemView.context.startActivity(intent)
                CustomIntent.customType(itemView.context, "fadein-to-fadeout")
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ActivityItemUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size
}
