package com.example.testingapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testingapi.repository.Repository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                return MainViewModel(repository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }

}