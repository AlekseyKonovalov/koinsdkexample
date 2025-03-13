package com.alekseik.feature.auth.di

import com.alekseik.feature.auth.data.AuthRepository
import com.alekseik.feature.auth.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    single { AuthRepository(get()) }
    viewModel { LoginViewModel(get()) }
}