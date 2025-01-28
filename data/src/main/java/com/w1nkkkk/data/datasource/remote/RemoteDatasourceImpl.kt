package com.w1nkkkk.data.datasource.remote

import com.w1nkkkk.data.entity.DataDtoModel
import retrofit2.await

class RemoteDatasourceImpl : RemoteDatasource {
    private val apiClient = ApiClient("https://drive.usercontent.google.com/")
    private val apiService = apiClient.retrofit.create(ApiService::class.java)

    override suspend fun getData(): DataDtoModel {
        return apiService.getData().await()
    }
}