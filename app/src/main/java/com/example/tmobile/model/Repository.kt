package com.example.tmobile.model

import com.example.tmobile.network.api.page.PageAPIHelper

class Repository (private val apiHelper: PageAPIHelper){
    suspend fun getPages() = apiHelper.getPages()
}