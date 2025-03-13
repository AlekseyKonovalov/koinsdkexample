package com.alekseik.feature.profile.data


class ProfileService() {
    suspend fun getUser(id: String): User {
        return User()
    }
}