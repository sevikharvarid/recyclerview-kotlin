package com.example.part2apps.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.part2apps.data.remote.api.ApiInterface
import com.example.part2apps.data.repository.MainRepository
import com.example.part2apps.viewmodel.MainViewModel



class MainViewModelFactory constructor(private val repository:MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}


