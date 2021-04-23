package com.dicoding.moviecatalogue.ui.splahsscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.moviecatalogue.databinding.ActivitySplashScreenBinding
import com.dicoding.moviecatalogue.ui.home.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}