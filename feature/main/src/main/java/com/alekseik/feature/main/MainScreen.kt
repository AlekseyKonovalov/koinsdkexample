package com.alekseik.feature.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alekseik.feature.auth.ui.LoginScreen
import com.alekseik.feature.profile.ui.ProfileScreen

@Composable
fun MainScreen() {
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