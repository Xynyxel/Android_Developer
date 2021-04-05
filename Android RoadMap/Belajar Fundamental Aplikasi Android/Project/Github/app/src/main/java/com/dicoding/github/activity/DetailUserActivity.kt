package com.dicoding.github.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.github.Model.User
import com.dicoding.github.R
import com.dicoding.github.databinding.ActivityDetailUserBinding
import maes.tech.intentanim.CustomIntent.customType

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ll.setBackgroundResource(R.drawable.gradient_background)

        val userdata = intent.getParcelableExtra<User>(EXTRA_USER) as User

        binding.tvUsernameDt.text = userdata.Username
        binding.tvNameDt.text = userdata.Name
        binding.tvLocationDt.text = userdata.Location
        binding.tvRepositoryDt.text = userdata.Repository.toString()
        binding.tvCompanyDt.text =  userdata.Company
        binding.tvFollowersDt.text = userdata.Followers.toString()
        binding.tvFollowingDt.text = userdata.Following.toString()

        Glide.with(this)
                .load(userdata.Avatar)
                .apply(RequestOptions().override(200, 200))
                .fitCenter()
                .into(binding.imgPhotoDetail)

        binding.backBtn.setOnClickListener {
            onBackPressed()
            customType(this,"fadein-to-fadeout")
        }
    }

    override fun finish() {
        super.finish()
        customType(this,"fadein-to-fadeout")
    }
}