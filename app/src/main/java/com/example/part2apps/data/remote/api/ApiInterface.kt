package com.example.part2apps.data.remote.api

import com.example.part2apps.data.remote.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface
{
    @GET("/jokes/search")
    fun getAllData(
        @Query("query") query: String
    ) : Call<ApiResponse>
}