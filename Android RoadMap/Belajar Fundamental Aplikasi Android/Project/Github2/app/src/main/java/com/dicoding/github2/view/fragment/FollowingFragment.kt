package com.dicoding.github2.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.github2.view.adapter.UserAdapter
import com.dicoding.github2.databinding.FragmentFollowingBinding
import com.dicoding.github2.view_model.MainViewModel

class FollowingFragment : Fragment() {
    var Username: String =""

    private var _binding : FragmentFollowingBinding?= null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel

    private lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowingBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        binding.rvFollowing.setHasFixedSize(true)
        adapter = UserAdapter()
        adapter.notifyDataSetChanged()
        makerecyclerviewfollowing(Username)
        binding.rvFollowing.layoutManager = LinearLayoutManager(context)
        binding.rvFollowing.adapter = adapter

        super.onViewCreated(view, savedInstanceState)
    }

    private fun makerecyclerviewfollowing(query: String){
        showLoading(true)
        mainViewModel.getfollow(query,1)
        mainViewModel.getUser().observe(this, { userItems ->
            if (userItems != null) {
                adapter.setData(userItems)
                showLoading(false)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.rvFollowing.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvFollowing.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

}