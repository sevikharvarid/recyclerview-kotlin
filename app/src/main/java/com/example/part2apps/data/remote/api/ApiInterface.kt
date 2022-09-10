package com.example.part2apps.data.remote.api

import com.example.part2apps.data.remote.response.ApiResponse
import com.example.part2apps.utils.Constant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/jokes/search")
    fun getAllData(
        @Query("query") query: String
    ) : Call<ApiResponse>

    companion object {
        var retrofitService: ApiInterface? = null
        fun getInstance(): ApiInterface {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiInterface::class.java)
            }
            return retrofitService!!
        }
    }
}
