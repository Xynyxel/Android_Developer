package com.dicoding.orio

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListTokoAdapter(private val listtoko: ArrayList<tokooleh2>) : RecyclerView.Adapter<ListTokoAdapter.ListViewHolder>() {

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btn_detail: Button = itemView.findViewById(R.id.btn_detail)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_toko_list, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val toko = listtoko[position]
        Glide.with(holder.itemView.context)
            .load(toko.photo_toko)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = toko.nama_toko
        holder.btn_detail.setOnClickListener {
            val intent = Intent(holder.btn_detail.context, Detail_toko::class.java)
            intent.putExtra(Detail_toko.EXTRA_TOKO, position)
            holder.btn_detail.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listtoko.size
    }
}

