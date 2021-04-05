package com.dicoding.mybackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.Executors.newSingleThreadExecutor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val tvStatus = findViewById<TextView>(R.id.tv_status)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        // Using handler
        /*btnStart.setOnClickListener{
            executor.execute{
                try{
                    // simullate process compressing
                    for (i in 0..10){
                        Thread.sleep(500)
                        val percentage = i * 10
                        handler.post{
                            //update ui in main thread
                            if(percentage == 100) tvStatus.setText(R.string.task_completed)
                            else tvStatus.text = String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
        }*/

        //Using Couroutine
        btnStart.setOnClickListener{
            lifecycleScope.launch(Dispatchers.Default){
                // simmulate process in background thread
                for(i in 0..10){
                    delay(500)
                    val percentage = i*10
                    withContext(Dispatchers.Main){
                        // Update UI in main  thread
                        if(percentage == 100){
                            tvStatus.setText(R.string.task_completed)
                        }else{
                            tvStatus.text = String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }
            }
        }
    }
}