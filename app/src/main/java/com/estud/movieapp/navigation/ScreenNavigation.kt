package com.estud.movieapp.navigation

enum class ScreenNavigation {
    HOME_SCREEN,
    DETAILS_SCREEN;

    companion object {
        fun getScreen(route: String?): ScreenNavigation {
            return when (route?.substringBefore("/")) {
                HOME_SCREEN.name -> HOME_SCREEN
                DETAILS_SCREEN.name -> DETAILS_SCREEN
                null -> HOME_SCREEN
                else -> throw IllegalArgumentException("route not found.")
            }
        }
    }
}