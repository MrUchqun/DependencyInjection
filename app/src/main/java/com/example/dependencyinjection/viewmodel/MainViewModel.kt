package com.example.dependencyinjection.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.model.Post
import com.example.dependencyinjection.network.RetrofitHttp
import com.example.dependencyinjection.network.service.PostService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postService: PostService) : ViewModel() {
    val allPosts = MutableLiveData<ArrayList<Post>>()

    fun apiPostList() {
        postService.listPost().enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                allPosts.value = response.body()
                Log.d("MainViewModel", "${response.body()}")
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                allPosts.value = ArrayList()
            }
        })
    }
}