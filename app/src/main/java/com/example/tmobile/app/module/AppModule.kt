package com.example.tmobile.app.module

import android.content.Context
import com.example.tmobile.network.NetworkHelper
import com.example.tmobile.network.api.page.PageAPIHelper
import com.example.tmobile.network.api.page.PageAPIImpl
import com.example.tmobile.network.api.page.PageAPIService
import com.example.tmobile.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{
    single { provideAPIService(get()) }
    single { provideNetworkHelper(get()) }
    single { provideOkHttpCLient() }
    single { provideRetrofit(get(),BASE_URL)}
    single<PageAPIHelper>{
        return@single PageAPIImpl(get())
    }
}


fun provideAPIService(retrofit: Retrofit): PageAPIService =
    retrofit.create(PageAPIService::class.java)

fun provideNetworkHelper(androidContext: Context) = NetworkHelper(androidContext)

fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

fun provideOkHttpCLient() = OkHttpClient.Builder().addInterceptor(interceptor).build()

val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
