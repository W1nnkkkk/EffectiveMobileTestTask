package com.w1nkkkk.data.datasource.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient (private val url : String) {
    private val httpClient : OkHttpClient = OkHttpClient.Builder().build()
    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}