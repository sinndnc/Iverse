package com.iverse.feature.navigation


const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"

sealed class Screens(val route: String) {
    object SplashUI : Screens("splash")
    object OnBoardUI : Screens("onboard")
    object RegisterUI : Screens("register")
    object LoginUI : Screens("login")
    object MainUI : Screens("main")
    object ChatRoomUI : Screens("chat")
}