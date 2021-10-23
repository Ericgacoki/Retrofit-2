package com.ericg.api.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericg.api.model.Quote
import com.ericg.api.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val response: MutableLiveData<Response<Quote>> = MutableLiveData()

    fun getQuote() {
        viewModelScope.launch {
            response.value = repository.getQuote()
        }
    }
}