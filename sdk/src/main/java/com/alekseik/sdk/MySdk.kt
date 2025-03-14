package com.alekseik.sdk

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alekseik.core.network.di.networkModule
import com.alekseik.feature.auth.di.authModule
import com.alekseik.feature.auth.ui.LoginScreen
import com.alekseik.feature.profile.di.profileModule
import com.alekseik.feature.profile.ui.ProfileScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

object MySdk {
    private var isInitialized = false

    fun initialize(
        context: Context,
        useGlobalKoin: Boolean = false
    ) {
        if (isInitialized) return
        if (useGlobalKoin) {
            loadKoinModules(
                listOf(
                    // core modules
                    networkModule,

                    // feature modules
                    authModule,
                    profileModule
                )
            )
        } else {
            startKoin {
                androidContext(context)
                modules(
                    // core modules
                    networkModule,

                    // feature modules
                    authModule,
                    profileModule
                )
            }
        }
        isInitialized = true
    }


    @Composable
    fun SdkEntryPoint() {
        val navController = rememberNavController()

        NavHost(navController, startDestination = "auth") {
            composable("auth") {
                LoginScreen(
                    navController
                )
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}
