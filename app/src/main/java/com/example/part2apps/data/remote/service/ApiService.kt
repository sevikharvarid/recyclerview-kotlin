package com.example.part2apps.data.remote.service

import com.example.part2apps.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object{
        private var retrofit: Retrofit? = null
        fun getInstance(): Retrofit{
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}

