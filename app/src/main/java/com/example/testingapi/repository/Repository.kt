package com.example.testingapi.repository

import com.example.testingapi.api.RetrofitInstance
import com.example.testingapi.model.Post
import retrofit2.Call
import retrofit2.Response

class Repository {
    fun getPost(): Call<ArrayList<Post>>{
        return RetrofitInstance.api.getPost()
    }
}