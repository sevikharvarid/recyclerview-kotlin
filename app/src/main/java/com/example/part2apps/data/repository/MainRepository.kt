package com.example.part2apps.data.repository

import com.example.part2apps.data.remote.api.ApiInterface

class MainRepository constructor(
    private val retrofitService: ApiInterface
) {
    fun getAllData(value: String) = retrofitService.getAllData(query = value)
}
