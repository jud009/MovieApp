package com.estud.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.estud.movieapp.screens.details.CreateDetailsScreen
import com.estud.movieapp.screens.home.CreateHomeScreen

@Composable
fun StartAppNavigation() {
    val navController = rememberNavController() //1
    NavHost( //2
        navController = navController,
        startDestination = ScreenNavigation.HOME_SCREEN.name
    ) {
        composable(ScreenNavigation.HOME_SCREEN.name) {
            CreateHomeScreen(navController = navController)
        }

        composable(ScreenNavigation.DETAILS_SCREEN.name) {
            CreateDetailsScreen(navController = navController)
        }
    }
}