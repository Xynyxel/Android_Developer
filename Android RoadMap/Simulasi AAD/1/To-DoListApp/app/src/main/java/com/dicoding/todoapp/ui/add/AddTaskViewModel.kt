package com.dicoding.todoapp.ui.add

import androidx.lifecycle.ViewModel
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.data.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddTaskViewModel(private val taskRepository: TaskRepository): ViewModel() {

    fun addTask(task : Task){
        GlobalScope.launch (Dispatchers.Main) {
            taskRepository.insertTask(task)
        }
    }
}