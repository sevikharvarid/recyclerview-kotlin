package com.example.part2apps.data.repository

import com.example.part2apps.data.remote.api.ApiInterface

class MainRepository constructor(
    private val retrofitService: ApiInterface,
    private val query: String
) {
    fun getAllData() = retrofitService.getAllData(query = query)
}
