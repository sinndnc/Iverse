package com.iverse.feature.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.iverse.core.utils.navigation.BottomNavigationDispatcher
import com.iverse.feature.component.bottomBar.BottomBarView
import com.iverse.feature.navigation.graph.BottomNavGraph


//TODO TEK BIR CONTAINER ALTINDAN DA YAPILABILIR ILERDE BAKILACAK DURUMUNA
@Composable
fun MainUI(
    viewModel: MainViewModel,
    bottomNavigationDispatcher: BottomNavigationDispatcher,
    lifecycleOwner: LifecycleOwner
) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Column(
        modifier = Modifier.background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomNavGraph(navController,bottomNavigationDispatcher, lifecycleOwner)
        BottomBarView(currentDestination, viewModel)
    }

}