package com.example.testingapi.model

data class Post(
    val age: Int,
    val id: Int,
    val content: String
)

data class Post2(
    val userId: Int,
    val title: String,
    val body: String
)