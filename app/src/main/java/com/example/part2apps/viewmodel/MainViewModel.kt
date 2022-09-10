package com.example.part2apps.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.part2apps.data.model.Jokes
import com.example.part2apps.data.remote.response.ApiResponse
import com.example.part2apps.data.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val dataList = MutableLiveData<List<Jokes>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllData() {
        val response = repository.getAllData()
        response.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                dataList.postValue(response.body()!!.results)
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}

