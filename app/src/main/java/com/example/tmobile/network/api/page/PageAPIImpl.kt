package com.example.tmobile.network.api.page

import com.example.tmobile.model.response.PageResponse
import retrofit2.Response

class PageAPIImpl(private val pageAPIService: PageAPIService) : PageAPIHelper {
    override suspend fun getPages(): Response<PageResponse> =
        pageAPIService.getPages()
}