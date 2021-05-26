package com.example.testingapi.api

import com.example.testingapi.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("movie/latest")
    suspend fun getPost(
        @Query("api_key") api_key: String
    ): Response<Post>

}