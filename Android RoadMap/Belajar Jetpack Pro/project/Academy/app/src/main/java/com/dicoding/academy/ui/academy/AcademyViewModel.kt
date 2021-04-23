package com.dicoding.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.academy.data.source.local.entity.CourseEntity
import com.dicoding.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()

}