package com.example.testingapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingapi.model.Post
import com.example.testingapi.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val myResponse: MutableLiveData<Call<ArrayList<Post>>> = MutableLiveData()

    fun getPost2() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}