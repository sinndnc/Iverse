package com.iverse.feature.presentation.main.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.iverse.feature.extensions.noRippleClickable


//TODO EDIT THIS CLASS
@Composable
fun ColumnScope.BottomBarView(
    currentDestination: NavDestination?,
    navController: NavController,
) {
    val screens = listOf(BottomPages.HOME, BottomPages.SEARCH, BottomPages.NOTIFICATIONS, BottomPages.MESSAGES)


    Row(
        modifier = Modifier.fillMaxSize().background(Color.DarkGray),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route }
            val iconColor = if (isSelected == true) MaterialTheme.colors.primary else Color.White

            Icon(
                painterResource(id = screen.icon),
                contentDescription = "${screen.title}",
                modifier = Modifier.noRippleClickable {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                tint = iconColor
            )
        }
    }
}