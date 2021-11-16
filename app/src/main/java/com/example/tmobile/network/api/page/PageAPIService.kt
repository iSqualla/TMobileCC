package com.example.tmobile.network.api.page

import com.example.tmobile.model.response.PageResponse
import retrofit2.Response
import retrofit2.http.GET

interface PageAPIService {

    @GET("test/home")
    suspend fun getPages():Response<PageResponse>
}