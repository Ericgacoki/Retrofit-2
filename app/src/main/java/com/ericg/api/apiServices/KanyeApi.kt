package com.ericg.api.apiServices

import com.ericg.api.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface KanyeApi {
    @GET("/")
    suspend fun getQuote(): Response<Quote>
}