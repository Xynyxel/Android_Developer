package com.dicoding.generation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edttahun : EditText
    private lateinit var output : TextView
    private lateinit var cari : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edttahun = findViewById(R.id.edt_tahun)
        output = findViewById(R.id.output)
        cari = findViewById(R.id.cari)

        cari.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.cari){
            val input_tahun = edttahun.text.toString().trim().toInt()

            when (input_tahun){
                in  1922..1945 -> output.text = "Tradisionalis"
                in  1946..1964 -> output.text = "Baby Boomers"
                in  1965..1980 -> output.text = "Generasi X"
                in  1981..1994 -> output.text = "Milenial"
                in  1995..2010 -> output.text = "Generasi Z"
                else -> output.text = "Alpha"
            }

        }
    }
}