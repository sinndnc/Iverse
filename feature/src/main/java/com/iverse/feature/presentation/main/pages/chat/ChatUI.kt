package com.iverse.feature.presentation.main.pages.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iverse.feature.presentation.main.MainViewModel
import com.iverse.feature.presentation.main.pages.chat.component.MessageBodyView
import com.iverse.feature.presentation.main.pages.chat.component.MessageHeaderView

@Composable
fun MessageUI(
    viewModel: ChatViewModel,
) {

    Column {
        MessageHeaderView(viewModel = viewModel)
        MessageBodyView(viewModel = viewModel)
    }
}