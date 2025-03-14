package com.alekseik.koinsdkexample.ui

import android.app.Application
import com.alekseik.core.network.di.networkModule
import com.alekseik.feature.auth.di.authModule
import com.alekseik.feature.profile.di.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                // core modules
                networkModule,

                // feature modules
                authModule,
                profileModule
            )
        }
    }

}