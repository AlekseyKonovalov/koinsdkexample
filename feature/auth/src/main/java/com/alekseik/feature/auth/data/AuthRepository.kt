package com.alekseik.feature.auth.data

import com.alekseik.core.network.OkHttpClient

class AuthRepository(private val okHttpClient: OkHttpClient) {
    suspend fun login(email: String, password: String): Boolean {
        // Логика авторизации
        okHttpClient.loadSomething("AuthRepository")
        return true
    }
}