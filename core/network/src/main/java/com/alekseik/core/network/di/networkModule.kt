package com.alekseik.core.network.di

import com.alekseik.core.network.OkHttpClient
import com.alekseik.core.network.OkHttpClientImpl
import org.koin.dsl.module

val networkModule = module {
    single<OkHttpClient> { OkHttpClientImpl() }
}