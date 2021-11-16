package com.example.tmobile.app

import android.app.Application
import com.example.tmobile.app.module.appModule
import com.example.tmobile.app.module.repositoryModule
import com.example.tmobile.app.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }
}