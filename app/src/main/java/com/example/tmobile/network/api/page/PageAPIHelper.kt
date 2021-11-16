package com.example.tmobile.network.api.page

import com.example.tmobile.model.response.PageResponse
import retrofit2.Response

interface PageAPIHelper {
    suspend fun getPages(): Response<PageResponse>
}