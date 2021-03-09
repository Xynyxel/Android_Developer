package com.dicoding.orio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvtoko: RecyclerView
    private var list: ArrayList<tokooleh2> = arrayListOf()


    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = title

        rvtoko = findViewById(R.id.rv_toko)
        rvtoko.setHasFixedSize(true)


        list.addAll(tokooleh2Data.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvtoko.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListTokoAdapter(list)
        rvtoko.adapter = listHeroAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_orio, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.profile ->{
                var moveintent = Intent(this, profile::class.java)
                startActivity(moveintent)
            }
        }
    }


}