package com.example.testingapi.repository

import com.example.testingapi.api.RetrofitInstance
import com.example.testingapi.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost("2e1261e8a26825b451ce77b008a3d2f9")
    }
}