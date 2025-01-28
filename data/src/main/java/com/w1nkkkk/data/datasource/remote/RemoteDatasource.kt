package com.w1nkkkk.data.datasource.remote

import com.w1nkkkk.data.entity.DataDtoModel

interface RemoteDatasource {
    suspend fun getData() : DataDtoModel
}