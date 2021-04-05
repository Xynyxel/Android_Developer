package com.dicoding.github

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.github.activity.MainActivity
import maes.tech.intentanim.CustomIntent
import java.lang.Exception

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread() {
            override fun run() {
                try{
                    sleep(2000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    CustomIntent.customType(this@SplashScreen, "fadein-to-fadeout")
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}