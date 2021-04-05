package com.dicoding.github2.view.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.github2.R
import com.dicoding.github2.view.adapter.SectionPagerAdapter
import com.dicoding.github2.databinding.ActivityDetailUserBinding
import com.dicoding.github2.model.User
import com.dicoding.github2.view_model.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import maes.tech.intentanim.CustomIntent

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"

        @StringRes
        private val TAB_TITLES = intArrayOf(
                R.string.following,
                R.string.followers
        )
    }
    private lateinit var mainViewModel: MainViewModel
    private var detailuser = User()

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutDetailuser.setBackgroundResource(R.drawable.gradient_background)

        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MainViewModel::class.java)

        val username = intent.getStringExtra(EXTRA_USER).toString()

        getDetail(username)
        addTabLayout(username)
    }

    override fun finish() {
        super.finish()
        CustomIntent.customType(this, "fadein-to-fadeout")
    }

    private fun showData() {
        Glide.with(this)
                .load(detailuser.Avatar)
                .apply(RequestOptions().override(200, 200))
                .fitCenter()
                .into(binding.imgPhotodt)
        binding.tvUsernamedt.text = detailuser.Username
        binding.tvNamedt.text = detailuser.Name
        binding.tvRepo.text = detailuser.Repository.toString()
        binding.tvFollowers.text = detailuser.Followers.toString()
        binding.tvFollowing.text = detailuser.Following.toString()
        binding.tvLocationdt.text = detailuser.Location
        binding.tvCompanydt.text = detailuser.Company
    }

    private fun addTabLayout(username: String) {
        val sectionPagerAdapter = SectionPagerAdapter(this)
        sectionPagerAdapter.username = username
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.layoutDetailuser.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.layoutDetailuser.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun getDetail(username: String){
        showLoading(true)
        mainViewModel.getdatauser(username)
        mainViewModel.getdetailUser().observe(this, { userItems ->
            if (userItems != null) {
                detailuser = userItems
                showData()
                showLoading(false)
            }
        })
    }
}