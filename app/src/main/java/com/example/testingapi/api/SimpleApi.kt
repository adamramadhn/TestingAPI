package com.example.testingapi.api

import com.example.testingapi.model.Post
import com.example.testingapi.model.Post2
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("Testing_API")
    fun getPost(): Call<ArrayList<Post>>

    @GET("api/train/")
    fun getPost2(): Call<ArrayList<Post>>

    @FormUrlEncoded
    @POST("api/prediction/")
    fun post(
        @Field("age")userId:Int,
        @Field("id")theId:Int,
    ): Call<Post2>

}