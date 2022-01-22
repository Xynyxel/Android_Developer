package com.dicoding.courseschedule.ui.list

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.courseschedule.data.DataRepository
import com.dicoding.courseschedule.ui.home.HomeViewModel
import java.lang.reflect.InvocationTargetException

class ListViewModelFactory(private val repository: DataRepository?): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            when {
                modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                    HomeViewModel(repository) as T
                }
                modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                    ListViewModel(repository) as T
                }
            }
            return modelClass.getConstructor(DataRepository::class.java).newInstance(repository)
        } catch (e: InstantiationException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        } catch (e: NoSuchMethodException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        } catch (e: InvocationTargetException) {
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        }
    }

    companion object {
        fun createFactory(activity: Activity): ListViewModelFactory {
            val context = activity.applicationContext
                ?: activity

            return ListViewModelFactory(DataRepository.getInstance(context))
        }
    }
}