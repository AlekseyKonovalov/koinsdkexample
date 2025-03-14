package com.alekseik.sdk

import android.content.Context
import androidx.compose.runtime.Composable
import com.alekseik.core.network.di.networkModule
import com.alekseik.feature.auth.di.authModule
import com.alekseik.feature.main.MainScreen
import com.alekseik.feature.profile.di.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

object MySdk {
    private var isInitialized = false
    private val sdkModules = listOf(
        // core modules
        networkModule,

        // feature modules
        authModule,
        profileModule
    )

    /**
     * Инициализирует DI в SDK
     *
     * @param context Application context
     * @param useGlobalKoin Передать true, если в проекте используется Koin, иначе false
     * */
    fun initialize(
        context: Context,
        useGlobalKoin: Boolean = false
    ) {
        if (isInitialized) return
        if (useGlobalKoin) {
            loadKoinModules(sdkModules)
        } else {
            startKoin {
                androidContext(context)
                modules(sdkModules)
            }
        }
        isInitialized = true
    }

    /**
     * Точка входа в SDK
     *
     * */
    @Composable
    fun SdkEntryPoint() {
        MainScreen()
    }
}
