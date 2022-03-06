package com.iverse.feature.presentation.main.pages.message

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.iverse.feature.presentation.main.MainViewModel
import com.iverse.feature.presentation.main.pages.message.component.MessageBodyView
import com.iverse.feature.presentation.main.pages.message.component.MessageHeaderView

@Composable
fun MessageUI(
    viewModel: MessageViewModel,
    mainViewModel: MainViewModel,
    mainNavController: NavController,
) {

    val scrollState = rememberScrollState(0)
    val systemUiController = rememberSystemUiController()

    Column {
        MessageHeaderView(viewModel = viewModel, scrollState = scrollState)
        MessageBodyView(
            viewModel = viewModel,
            scrollState = scrollState,
            mainViewModel = mainViewModel,
            mainNavController = mainNavController
        )
    }
}