package com.ericg.api.repository

import com.ericg.api.model.Quote
import com.ericg.api.retrofit.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getQuote(): Response<Quote> {
        return RetrofitInstance.api.getQuote()
    }
}