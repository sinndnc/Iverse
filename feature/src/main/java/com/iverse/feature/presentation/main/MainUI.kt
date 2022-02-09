package com.iverse.feature.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iverse.feature.presentation.main.bottomBar.BottomBarView
import com.iverse.feature.presentation.main.bottomBar.BottomNavGraph

@Composable
fun MainUI() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Column{
        BottomNavGraph(navController)
        BottomBarView(currentDestination, navController)
    }

}