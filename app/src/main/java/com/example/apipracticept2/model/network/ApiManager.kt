package com.example.apipracticept2.model.network

class ApiManager {

    private var postService: PostService =
        RetrofitInstance.providesRetrofit().create(PostService::class.java)

    suspend fun getPosts() = postService.getPosts()
}