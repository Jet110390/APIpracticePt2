package com.example.apipracticept2.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.apipracticept2.model.network.models.User
import com.example.apipracticept2.model.repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class PostsViewModel(
    private val postRepository: PostRepository
): ViewModel() {
    private var _posts: MutableLiveData<List<User>?> = MutableLiveData()
    val posts: LiveData<List<User>?> = _posts


    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val response = postRepository.getPosts()
            _posts.postValue(response)
        }
    }

    class Factory(
        private val postRepository: PostRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
                return PostsViewModel(postRepository) as T
                } else{
                    throw RuntimeException("Could not create instance of PostViewModel")
            }
        }
    }
}