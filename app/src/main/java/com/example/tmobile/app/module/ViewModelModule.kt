package com.example.tmobile.app.module

import com.example.tmobile.ui.viewmodel.PageViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PageViewModel(get(),get())
    }
}