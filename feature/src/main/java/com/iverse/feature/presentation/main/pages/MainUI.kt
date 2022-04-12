package com.iverse.feature.presentation.main.pages

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iverse.feature.component.bottomBar.BottomBarView
import com.iverse.feature.navigation.graph.BottomNavGraph
import com.iverse.feature.presentation.main.MainViewModel

@Composable
fun MainUI(viewModel: MainViewModel) {

    val barNavController = rememberNavController()
    val navBackStackEntry by barNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Column {
        BottomNavGraph(
            navController = barNavController
        )
        BottomBarView(
            currentDestination = currentDestination,
            navController = barNavController,
        )
    }
}