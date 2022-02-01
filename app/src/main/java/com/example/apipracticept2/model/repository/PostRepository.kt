package com.example.apipracticept2.model.repository

import com.example.apipracticept2.model.network.ApiManager
import com.example.apipracticept2.model.network.models.User
import java.lang.Exception

class PostRepository (
    private val apiManager: ApiManager
) {
    suspend fun getPosts(): List<User>? {
        return try {
            val response = apiManager.getPosts()
            if (response.isSuccessful) {
                response.body()
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }

}