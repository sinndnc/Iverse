package com.iverse.feature.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.statusBarsPadding
import com.iverse.feature.component.bottomBar.BottomBarView
import com.iverse.feature.navigation.BottomNavGraph


//TODO TEK BIR CONTAINER ALTINDAN DA YAPILABILIR ILERDE BAKILACAK DURUMUNA
@Composable
fun MainUI(mainNavController: NavHostController) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Column(
        modifier = Modifier.background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomNavGraph(navController = navController, mainNavController = mainNavController)
        BottomBarView(currentDestination, navController)
    }

}