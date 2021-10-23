package com.ericg.api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.ericg.api.R
import com.ericg.api.repository.Repository
import com.ericg.api.viewModel.MainViewModel
import com.ericg.api.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = Repository()
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository) ).get(MainViewModel::class.java)

        try{
            mainViewModel.getQuote()
            mainViewModel.response.observe(this, { response ->
                if (response.isSuccessful){
                    Log.i("MainActivity", "${response.body()?.quote}")
                }
            })
        } catch (e: Exception){
            Log.e("MainActivity", e.toString())
        }
    }
}