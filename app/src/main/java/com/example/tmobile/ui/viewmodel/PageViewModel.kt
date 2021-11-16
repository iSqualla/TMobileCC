package com.example.tmobile.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobile.model.Repository
import com.example.tmobile.model.response.Page
import com.example.tmobile.model.response.PageResponse
import com.example.tmobile.network.NetworkHelper
import kotlinx.coroutines.launch
import retrofit2.Response

class PageViewModel(
    private val repo: Repository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _pages = MutableLiveData<Response<PageResponse>>()
    val pages: LiveData<Response<PageResponse>>
        get() = _pages

    init {
        fetchPages()
    }

    fun fetchPages() {
        viewModelScope.launch {
            repo.getPages().let {
                _pages.postValue(it)
            }
        }
    }
}