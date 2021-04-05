package com.dicoding.github2.view.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.github2.view.fragment.FollowerFragment
import com.dicoding.github2.view.fragment.FollowingFragment

class  SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    var username = "username"

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment?= null
        when(position){
            0 ->{
                fragment = FollowerFragment()
                fragment.Username = username
            }
            1 ->{
                fragment = FollowingFragment()
                fragment.Username = username
            }
        }
        return fragment as Fragment
    }

}