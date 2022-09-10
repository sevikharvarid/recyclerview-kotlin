package com.example.part2apps.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.part2apps.R
import com.example.part2apps.data.remote.api.ApiInterface
import com.example.part2apps.data.repository.MainRepository
import com.example.part2apps.databinding.ActivityMainBinding
import com.example.part2apps.ui.adapter.RecycleAdapter
import com.example.part2apps.utils.MainViewModelFactory
import com.example.part2apps.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = ApiInterface.getInstance()
    val adapter = RecycleAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvListData.adapter = adapter
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService)))
                .get(MainViewModel::class.java)
        viewModel.dataList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setDataList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "onError: $it")
        })

        binding.btnSearch.setOnClickListener {
            Toast.makeText(this,searchData.query,Toast.LENGTH_SHORT).show()
            viewModel.getAllData(value = searchData.query.toString())
        }
    }
}

