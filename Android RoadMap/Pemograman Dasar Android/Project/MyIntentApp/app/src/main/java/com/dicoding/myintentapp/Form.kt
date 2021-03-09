package com.dicoding.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Form : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val btn_kirim : Button = findViewById(R.id.btn_kirim)
        btn_kirim.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val nama : EditText = findViewById(R.id.edt_nama)
        val umur : EditText = findViewById(R.id.edt_umur)
        when(p0?.id){
            R.id.btn_kirim -> {
                val moveWithDataIntent = Intent(this@Form, MoveWithData::class.java)
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, nama.text.toString())
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE, umur.text.toString().toInt())
                startActivity(moveWithDataIntent)
            }
        }
    }
}