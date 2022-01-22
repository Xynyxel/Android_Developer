package com.dicoding.todoapp.setting

import androidx.lifecycle.ViewModel
import com.dicoding.todoapp.data.TaskRepository

class NearestTaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    fun nearestTask() = taskRepository.getNearestActiveTask()
}