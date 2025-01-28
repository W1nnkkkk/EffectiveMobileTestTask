package com.w1nkkkk.data.datasource.remote

import com.w1nkkkk.data.entity.DataDtoModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    fun getData() : Call<DataDtoModel>
}