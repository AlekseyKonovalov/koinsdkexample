package com.alekseik.core.network

import android.util.Log
import kotlinx.coroutines.delay

interface OkHttpClient {
    suspend fun loadSomething(tag: String)
}

internal class OkHttpClientImpl : OkHttpClient {
    override suspend fun loadSomething(tag: String) {
        Log.d("OkHttpClientImpl from $tag", "STARTED LOADING")
        delay(3000L)
        Log.d("OkHttpClientImpl from $tag", "LOADED")
    }
}
