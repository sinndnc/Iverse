package com.iverse.feature.presentation.main.pages.message.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iverse.feature.presentation.main.pages.message.chat.component.ChatAppBar
import com.iverse.feature.presentation.main.pages.message.chat.component.ChatBottomBar
import com.iverse.feature.presentation.main.pages.message.chat.component.ChatList
import com.iverse.feature.presentation.main.pages.message.chat.component.MessageBubble


@Composable
fun ChatUI(navController: NavController, viewModel: ChatViewModel, image: String, name: String) {

    val listState = rememberLazyListState()
    val messageList = viewModel.messageList.reversed()

    Column {
        ChatAppBar(image = image, name = name) { navController.navigateUp() }
        ChatList(listState = listState, messageList = messageList)
        ChatBottomBar(viewModel = viewModel)
    }


}