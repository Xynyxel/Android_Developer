package com.dicoding.orio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Detail_toko : AppCompatActivity() {

    companion object {
        const val EXTRA_TOKO = "extra_toko"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_toko)


        val posisitoko = intent.getIntExtra(EXTRA_TOKO, 0)
        var list = tokooleh2Data.listData[posisitoko]

        val namatoko = findViewById<TextView>(R.id.nama_toko)
        namatoko.text = list.nama_toko

        val daerahtoko = findViewById<TextView>(R.id.daerah_toko)
        daerahtoko.text = list.daerah_toko

        val alamattoko = findViewById<TextView>(R.id.alamat_toko)
        alamattoko.text = list.alamat_toko

        val image_toko = findViewById<ImageView>(R.id.image_toko)
        image_toko.setImageResource(list.photo_toko)

        val btn = findViewById<FloatingActionButton>(R.id.btn)
        btn.setOnClickListener(){
            val moveIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("google.navigation:q=${list.koordinat_toko}&mode=d"))
            moveIntent.setPackage("com.google.android.apps.maps")
                startActivity(moveIntent)

        }
    }

}