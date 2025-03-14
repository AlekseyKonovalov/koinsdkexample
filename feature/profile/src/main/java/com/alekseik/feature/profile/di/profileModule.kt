package com.alekseik.feature.profile.di

import com.alekseik.feature.profile.data.ProfileRepository
import com.alekseik.feature.profile.data.ProfileService
import com.alekseik.feature.profile.ui.ProfileViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    single { ProfileService() }
    single { ProfileRepository(get()) }
    viewModel { ProfileViewModel(get()) }
}