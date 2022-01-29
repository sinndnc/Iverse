package com.iverse.feature.presentation.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iverse.feature.component.view.Container

@Composable
fun HomeUI(navController: NavController) {
    Container() {
        Text(text = "HOME UI")
    }
}