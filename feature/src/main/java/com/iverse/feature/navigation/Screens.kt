package com.iverse.feature.navigation

sealed class Screens(val route: String) {
    object OnBoardUI : Screens("onboard")
    object SplashUI : Screens("splash")
    object LoginUI : Screens("login")
    object RegisterUI : Screens("register")
    object HomeUI : Screens("home")
}