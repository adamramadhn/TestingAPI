package com.example.testingapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingapi.api.RetrofitInstance
import com.example.testingapi.databinding.ActivityMainBinding
import com.example.testingapi.model.Post
import com.example.testingapi.model.Post2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

//    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private val list = ArrayList<Post>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getPost()
        val x = 1
        RetrofitInstance.api.post(x,x).enqueue(object : Callback<Post2>{
            override fun onResponse(call: Call<Post2>, response: Response<Post2>) {
//                mainBinding.textview.text = "Title: ${response.body()?.userId}"
            }

            override fun onFailure(call: Call<Post2>, t: Throwable) {
                Log.d("Response POST", t.message.toString())
            }

        })
        RetrofitInstance.api.getPost2().enqueue(object : Callback<ArrayList<Post>> {
            //Jika array
            override fun onResponse(
                call: Call<ArrayList<Post>>,
                response: Response<ArrayList<Post>>
            ) {
                val adapter = Adapter(list)
//                Log.d("Response", response.body().toString())
                adapter.setData(response.body())
                mainBinding.rvList.adapter = adapter
                Log.d("onResponse Success", response.code().toString())
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                Log.d("onResponse Fail", t.message.toString())
            }


            //jika hanya object ============
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                mainBinding.textview.text = "Title: ${response.body()?.age}\nDesc:\t${response.body()?.desc}"
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("Response GET", t.message.toString())
//            }
            //==================
        })
        mainBinding.apply {
            rvList.setHasFixedSize(true)
            rvList.layoutManager = LinearLayoutManager(this@MainActivity)
        }
//        viewModel.myResponse.observe(this, {
//        it.enqueue(object : Callback<ArrayList<Post>>{
//            override fun onResponse(
//                call: Call<ArrayList<Post>>,
//                response: Response<ArrayList<Post>>
//            ) {
//               mainBinding.textview.text = response.body().toString()
//            }
//
//            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//            if (it.isSuccessful) {
//                Log.d("Response", it.body()?.userId.toString())
//                it.body()?.id?.let { it1 -> Log.d("Response", it1) }
//                it.body()?.title?.let { it1 -> Log.d("Response", it1) }
//                mainBinding.textview.text =
//                    "Title: ${it.body()?.userId}\nDescription: ${it.body()?.id}\nContent: ${it.body()?.title}"
//            } else {
//                Log.d("Response", it.errorBody().toString())
//                mainBinding.textview.text = it.code().toString()
//            }
//        })
    }
}