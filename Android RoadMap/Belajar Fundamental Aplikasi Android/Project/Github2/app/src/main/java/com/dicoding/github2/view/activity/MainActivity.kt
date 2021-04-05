package com.dicoding.github2.view.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.github2.R
import com.dicoding.github2.databinding.ActivityMainBinding
import com.dicoding.github2.view.adapter.UserAdapter
import com.dicoding.github2.view_model.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    var mSearchString: String = ""
    private lateinit var searchView : SearchView

    companion object{
        const val SEARCH_KEY = "search_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState != null){
            mSearchString = savedInstanceState.getString(SEARCH_KEY).toString()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)


        supportActionBar?.title = "Github"
        binding.rvUser.setHasFixedSize(true)
        adapter = UserAdapter()
        adapter.notifyDataSetChanged()
        makerecyclerview()
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = adapter
        binding.layoutMain.setBackgroundResource(R.drawable.gradient_background)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mSearchString = searchView.query.toString()
        outState.putString(SEARCH_KEY, mSearchString)
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)

        if (mSearchString.isNotEmpty()) {
            searchView.visibility = View.VISIBLE
            searchView.onActionViewExpanded()
            searchView.setQuery(mSearchString, true)
            searchView.clearFocus()
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                mSearchString = query
                binding.tvNotfound.visibility = View.GONE
                if (mSearchString == "") {
                    makerecyclerview()
                } else {
                    showLoading(true)
                    makerecyclerviewfind(mSearchString)
                }
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                mSearchString = query
                binding.tvNotfound.visibility = View.GONE
                if (mSearchString == "") {
                    makerecyclerview()
                } else {
                    showLoading(true)
                    makerecyclerviewfind(mSearchString)
                }
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.language -> {
                val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)
                true
            }
            else -> true
        }
    }

    private fun makerecyclerview() {
        showLoading(true)
        mainViewModel.getAllUser()
        mainViewModel.getUser().observe(this, { userItems ->
            binding.tvNotfound.visibility = View.GONE
            if (userItems.size == 0) {
                showLoading(true)
                lifecycleScope.launch(Dispatchers.Default) {
                    delay(1000)
                    withContext(Dispatchers.Main) {
                        showLoading(false)
                        binding.tvNotfound.visibility = View.VISIBLE
                    }
                }
            }
            if (userItems != null) {
                adapter.setData(userItems)
                showLoading(false)
            }
        })
    }

    private fun makerecyclerviewfind(query: String) {
        mainViewModel.finduser(query)
    }


    private fun showLoading(state: Boolean) {
        if (state) {
            binding.rvUser.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvUser.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }


}