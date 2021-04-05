package com.dicoding.github2.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.github2.view.adapter.UserAdapter
import com.dicoding.github2.databinding.FragmentFollowerBinding
import com.dicoding.github2.view_model.MainViewModel

class FollowerFragment: Fragment() {
    var Username: String =""

    private var _binding : FragmentFollowerBinding?= null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        binding.rvFollowers.setHasFixedSize(true)
        adapter = UserAdapter()
        adapter.notifyDataSetChanged()
        makerecyclerviewfollower(Username)
        binding.rvFollowers.layoutManager = LinearLayoutManager(context)
        binding.rvFollowers.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }


    private fun makerecyclerviewfollower(query: String){
        showLoading(true)
        mainViewModel.getfollow(query,2)
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
            binding.rvFollowers.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvFollowers.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }


}