package com.iverse.feature.component.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.iverse.core.utils.navigation.Screens
import com.iverse.feature.component.icon.CustomIcon
import com.iverse.feature.navigation.content.BottomPages
import com.iverse.feature.presentation.main.MainViewModel


//TODO EDIT THIS CLASS
@Composable
fun ColumnScope.BottomBarView(
    currentDestination: NavDestination?,
    viewModel: MainViewModel,
) {

    val screens = listOf(BottomPages.HOME, BottomPages.SEARCH, BottomPages.NOTIFICATIONS, BottomPages.MESSAGES)
    val backgroundBrush = Brush.verticalGradient(listOf(MaterialTheme.colors.onPrimary, Color.Transparent))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(0.08F)
            .background(backgroundBrush, MaterialTheme.shapes.large),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            CustomIcon(
                icon = screen.icon,
                isSelected = isSelected
            ) {
                viewModel.navigateTo(screen.route)
            }
        }
    }
}