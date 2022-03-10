package com.iverse.feature.presentation.main.pages.message.chat.component

import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iverse.feature.presentation.main.pages.message.chat.ChatViewModel

@Composable
fun ChatBottomBar(viewModel: ChatViewModel) {

    ChatTextField(modifier = Modifier.imePadding()) { text ->
        viewModel.sendMessageToUser(text)
    }

}