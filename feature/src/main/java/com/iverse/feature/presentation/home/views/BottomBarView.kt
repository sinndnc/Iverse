package com.iverse.feature.presentation.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

//TODO EDIT THIS CLASS
@Composable
fun BottomBarView(
    selectedRoute: String,
    onItemSelected: (Pages) -> Unit
) {

    val items = listOf(
        Pages.HOME,
        Pages.SEARCH,
        Pages.NOTIFICATIONS,
        Pages.MESSAGES
    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        items.forEach {
            val isSelected = it.route == selectedRoute

            val color = if (isSelected)
                MaterialTheme.colors.primary
            else
                MaterialTheme.colors.onSurface.copy(alpha = 0.3f)

            IconButton(onClick = {
                if (!isSelected)
                    onItemSelected(it)
            }) {
                Icon(
                    painterResource(id = it.icon),
                    contentDescription = null,
                    tint = color
                )
            }

        }


    }

}