package com.dicoding.github.activity

import android.content.res.TypedArray
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.github.adapter.UserAdapter
import com.dicoding.github.Model.User
import com.dicoding.github.R
import com.dicoding.github.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var users = arrayListOf<User>()

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhoto: TypedArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityMain.setBackgroundResource(R.drawable.gradient_background)

        binding.rvUser.setHasFixedSize(true)
        getlistUser()
        showRecyclerList()
        binding.popup.setOnClickListener(this)
    }


    private fun getlistUser(): ArrayList<User> {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)

        for (position in dataName.indices) {
            users.add(
                User(
                    dataUsername[position],
                    dataName[position],
                    dataLocation[position],
                    dataRepository[position].toInt(),
                    dataCompany[position],
                    dataFollowers[position].toInt(),
                    dataFollowing[position].toInt(),
                    dataPhoto.getResourceId(position, -1)
            )
            )
        }
        return users
    }

    private fun showRecyclerList() {
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = UserAdapter(users, "list")
        binding.rvUser.adapter = listUserAdapter

    }

    private fun showGridList() {
        binding.rvUser.layoutManager = GridLayoutManager(this,2)
        val listUserAdapter = UserAdapter(users, "grid")
        binding.rvUser.adapter = listUserAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onClick(v: View?) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_main, popup.menu)
        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_list -> {
                    showRecyclerList()
                }
                R.id.action_grid -> {
                    showGridList()
                }
            }
            true
        }
        popup.show()
    }
}
