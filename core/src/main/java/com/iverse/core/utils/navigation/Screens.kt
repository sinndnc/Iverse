package com.iverse.core.utils.navigation

sealed class Screens(val route: String) {
    object SplashUI : Screens("splash")
    object OnBoardUI : Screens("onboard")
    object RegisterUI : Screens("register")
    object LoginUI : Screens("login")
    object MainUI : Screens("main")
    object ChatUI : Screens("chat")

}