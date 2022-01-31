package com.example.apipracticept2.model.network

import com.example.apipracticept2.model.network.models.User
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("users")
    suspend fun getPosts(): Response<List<User>>

}