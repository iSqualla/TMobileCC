package com.example.tmobile.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobile.model.Repository
import com.example.tmobile.model.response.CardsItem
import com.example.tmobile.model.response.Page
import com.example.tmobile.model.response.PageResponse
import com.example.tmobile.network.NetworkHelper
import kotlinx.coroutines.launch
import retrofit2.Response

class PageViewModel(
    private val repo: Repository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _pages = MutableLiveData<List<CardsItem>>()
    val pages: LiveData<List<CardsItem>>
        get() = _pages

    //makes a call as soon as viewmodel is required to start the process sooner
    init {
        fetchPages()
    }

    //fetches the List of items that will populate the view
    fun fetchPages(){
        viewModelScope.launch {
            repo.getPages().let {
                var response = it.body() as PageResponse

                _pages.postValue(response.page?.cards as List<CardsItem>?)
            }
        }
    }
}