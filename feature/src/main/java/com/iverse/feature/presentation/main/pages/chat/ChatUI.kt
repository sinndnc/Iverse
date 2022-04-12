package com.iverse.feature.presentation.main.pages.chat

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import com.iverse.feature.presentation.main.pages.chat.component.ChatBodyView
import com.iverse.feature.presentation.main.pages.chat.component.MessageHeaderView

@Composable
fun ChatUI(
    viewModel: ChatViewModel,
) {
    Column {
        MessageHeaderView(viewModel = viewModel)
        ChatBodyView(viewModel = viewModel)
    }
}