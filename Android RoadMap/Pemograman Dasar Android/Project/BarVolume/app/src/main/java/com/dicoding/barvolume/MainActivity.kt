package com.dicoding.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var edtpanjang: EditText
    private lateinit var edtlebar: EditText
    private lateinit var edttinggi: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtpanjang = findViewById(R.id.edt_panjang)
        edtlebar = findViewById(R.id.edt_tinggi)
        edttinggi = findViewById(R.id.edt_lebar)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

    }

    override fun onClick(v: View?){
        if (v?.id == R.id.btn_calculate){
            val inputpanjang = edtpanjang.text.toString().trim()
            val inputlebar = edtlebar.text.toString().trim()
            val inputtinggi = edttinggi.text.toString().trim()

            val volume = inputpanjang.toDouble() * inputlebar.toDouble() * inputtinggi.toDouble()
            tvResult.text = volume.toString()
        }
    }

}

