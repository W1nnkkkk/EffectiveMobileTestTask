package com.w1nkkkk.data.datasource.remote

import retrofit2.http.GET

interface ApiService {
    @GET("u/0/uc?id%3D1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r%26export%3Ddownload")
    fun getData()
}