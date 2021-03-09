package com.dicoding.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithData.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveIntent = Intent(this@MainActivity, Form::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "0895615649248"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}