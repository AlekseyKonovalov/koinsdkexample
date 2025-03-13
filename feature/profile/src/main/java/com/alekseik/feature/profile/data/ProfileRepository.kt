package com.alekseik.feature.profile.data

class ProfileRepository(private val profileService: ProfileService) {
    suspend fun getUserProfile(): User {
        // Логика получения данных профиля
        return profileService.getUser("1")
    }
}