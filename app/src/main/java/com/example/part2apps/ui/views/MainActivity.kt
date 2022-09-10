package com.example.part2apps.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.part2apps.R
import com.example.part2apps.data.model.Jokes
import com.example.part2apps.data.remote.api.ApiInterface
import com.example.part2apps.data.remote.response.ApiResponse
import com.example.part2apps.data.remote.service.ApiService
import com.example.part2apps.ui.adapter.RecycleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var searchValue = ""
    private lateinit var recyclerAdapter: RecycleAdapter
    private lateinit var recyclerLayourManager: LinearLayoutManager
    private lateinit var recyclerList: List<Jokes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerLayourManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_list_data.layoutManager = recyclerLayourManager
        rv_list_data.adapter = recyclerAdapter
        rv_list_data.setHasFixedSize(true)

        getListData { jokes: List<Jokes> ->
            rv_list_data.adapter = RecycleAdapter(jokes as MutableList<Jokes>)
        }

    }

    private fun getListData(callback: (List<Jokes>) -> Unit) {
        val apiService = ApiService.getInstance().create(ApiInterface::class.java)
        apiService.getAllData(query = "test").enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                return onDataFetched(response.body()!!.result)
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            }

        })
//        apiService.getMovieList(page = popularMoviesPage).enqueue(object : Callback<ApiResponse> {
//            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
//                return onPopularMoviesFetched(response.body()!!.movies)
//            }
//
//            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {}
//        })
    }
    private fun onDataFetched(list: List<Jokes>) {
        recyclerAdapter.appendData(list)
        recyclerList = list
        recyclerAdapter.notifyDataSetChanged()
    }

}