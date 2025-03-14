package com.alekseik.core.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface OkHttpClient {
    suspend fun loadSomething(tag: String)
}

internal class OkHttpClientImpl : OkHttpClient {

    override suspend fun loadSomething(tag: String) {
        withContext(Dispatchers.IO) {
            Log.d("OkHttpClientImpl from $tag", "STARTED LOADING")
            delay(1000L)
            Log.d("OkHttpClientImpl from $tag", "LOADED")
        }
    }
}
