package com.dicoding.academy.data.source

import androidx.lifecycle.LiveData
import com.dicoding.academy.data.source.local.entity.CourseEntity
import com.dicoding.academy.data.source.local.entity.ModuleEntity

interface AcademyDataSource {

    interface AcademyDataSource {

        fun getAllCourses(): LiveData<List<CourseEntity>>

        fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

        fun getCourseWithModules(courseId: String): LiveData<CourseEntity>

        fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>

        fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>
    }
}