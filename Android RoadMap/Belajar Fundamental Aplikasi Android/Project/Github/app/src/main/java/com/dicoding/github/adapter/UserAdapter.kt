package com.dicoding.github.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.github.Model.User
import com.dicoding.github.R
import com.dicoding.github.activity.DetailUserActivity
import com.dicoding.github.databinding.ActivityGridUserBinding
import com.dicoding.github.databinding.ActivityItemUserBinding
import maes.tech.intentanim.CustomIntent

class UserAdapter(private val listUser: ArrayList<User>,private val type: String) : RecyclerView.Adapter<UserAdapter.ListViewHolder>()  {
    private lateinit var binding: ActivityItemUserBinding
    private lateinit var bindinggrid: ActivityGridUserBinding

    fun cekbinding(): View{
        if(type == "grid") {
            return bindinggrid.root
        }
        else {
            return binding.root
        }
    }

    inner class ListViewHolder(val type: String) : RecyclerView.ViewHolder(cekbinding()) {
        fun bind(user: User) {
            if(type == "list") {
                with(binding) {
                    Glide.with(itemView.context)
                            .load(user.Avatar)
                            .apply(RequestOptions().override(200, 200))
                            .into(binding.imgPhoto)
                    binding.cv.setBackgroundResource(R.drawable.card_background)
                    binding.txtUsername.text = user.Username
                    binding.txtName.text = user.Name

                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailUserActivity::class.java)
                        intent.putExtra(DetailUserActivity.EXTRA_USER, user)
                        itemView.context.startActivity(intent)
                        CustomIntent.customType(itemView.context, "fadein-to-fadeout")
                    }
                }
            }
            else if(type == "grid") {
                with(bindinggrid) {
                    Glide.with(itemView.context)
                            .load(user.Avatar)
                            .apply(RequestOptions().override(200, 200))
                            .into(bindinggrid.imgItemPhoto)
                    bindinggrid.cv.setBackgroundResource(R.drawable.card_background)
                    bindinggrid.tvUsernameDt.text = user.Username
                    bindinggrid.tvUsernameDt.setBackgroundResource(R.drawable.cardviewgrid)

                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailUserActivity::class.java)
                        intent.putExtra(DetailUserActivity.EXTRA_USER, user)
                        itemView.context.startActivity(intent)
                        CustomIntent.customType(itemView.context, "fadein-to-fadeout")
                    }
                }
            }
        }
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        binding = ActivityItemUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false )
        bindinggrid = ActivityGridUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false )
        return ListViewHolder(type)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size
}
