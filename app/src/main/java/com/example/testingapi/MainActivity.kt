package com.example.testingapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testingapi.databinding.ActivityMainBinding
import com.example.testingapi.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, {
            if (it.isSuccessful) {
                Log.d("Response", it.body()?.id.toString())
                it.body()?.title?.let { it1 -> Log.d("Response", it1) }
                it.body()?.overview?.let { it1 -> Log.d("Response", it1) }
                mainBinding.textview.text =
                    "Title: ${it.body()?.title}\nOverview: ${it.body()?.overview}"
            } else {
                Log.d("Response", it.errorBody().toString())
                mainBinding.textview.text = it.code().toString()
            }
        })
    }
}