package com.iverse.feature.component.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.iverse.feature.component.icon.CustomIcon
import com.iverse.feature.navigation.content.BottomScreens
import com.iverse.feature.presentation.main.MainViewModel
import kotlinx.coroutines.launch


//TODO EDIT THIS CLASS
@Composable
fun ColumnScope.BottomBarView(
    currentDestination: NavDestination?,
    navController: NavController,
) {

    val screens = listOf(BottomScreens.HOME, BottomScreens.SEARCH, BottomScreens.NOTIFICATIONS, BottomScreens.CHAT)
    val backgroundBrush = Brush.verticalGradient(listOf(MaterialTheme.colors.onPrimary, Color.Transparent))
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(0.08f)
            .background(backgroundBrush, MaterialTheme.shapes.large),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            CustomIcon(icon = screen.icon, isSelected = isSelected) {
                coroutineScope.launch {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }
}