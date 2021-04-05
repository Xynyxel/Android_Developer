package com.dicoding.github2.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.github2.R
import maes.tech.intentanim.CustomIntent

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread() {
            override fun run() {
                try{
                    sleep(2000)
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    finish()
                    CustomIntent.customType(this@SplashScreenActivity, "fadein-to-fadeout")
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}