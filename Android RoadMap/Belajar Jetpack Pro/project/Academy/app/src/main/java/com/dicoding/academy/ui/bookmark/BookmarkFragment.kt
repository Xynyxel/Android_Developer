package com.dicoding.academy.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.academy.R
import com.dicoding.academy.data.source.local.entity.CourseEntity
import com.dicoding.academy.databinding.FragmentBookmarkBinding
import com.dicoding.academy.viewmodel.ViewModelFactory


class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

            val adapter = BookmarkAdapter(this)

            fragmentBookmarkBinding.progressBar.visibility = View.VISIBLE
            viewModel.getBookmarks().observe(viewLifecycleOwner, { courses ->
                fragmentBookmarkBinding.progressBar.visibility = View.GONE
                adapter.setCourses(courses)
                adapter.notifyDataSetChanged()
            })

            with(fragmentBookmarkBinding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder.from(requireActivity()).apply {
                setType(mimeType)
                setChooserTitle("Bagikan aplikasi ini sekarang.")
                setText("Segera daftar kelas ${course.title} di dicoding.com")
            }.startChooser()
        }
    }
}