package com.example.tmobile.app.module

import com.example.tmobile.model.Repository
import org.koin.dsl.module

val repositoryModule = module{
    single{
        Repository(get())
    }
}