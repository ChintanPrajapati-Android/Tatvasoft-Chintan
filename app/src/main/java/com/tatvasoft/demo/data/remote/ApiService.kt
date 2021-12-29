package com.tatvasoft.demo.data.remote

import com.tatvasoft.demo.model.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("api/users")
    suspend fun getData(
        @Query("page") page: Int = 1
    ): Response<DataModel>
}

