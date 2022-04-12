package com.iverse.feature.presentation.main.pages.chat.chat_room

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalDensity
import com.google.accompanist.insets.LocalWindowInsets
import com.iverse.feature.presentation.main.pages.chat.chat_room.component.*
import kotlinx.coroutines.launch

@Composable
fun ChatRoomUI(viewModel: ChatRoomViewModel, chatUid: String) {

    val messages = viewModel.messages.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = 16)
    val isOpen = WindowInsets.Companion.ime.getBottom(LocalDensity.current) > 0

    LaunchedEffect(Unit) {
        viewModel.getChatRoomMessages(chatUid)
    }

    DisposableEffect(isOpen) {
        if (isOpen) {
            coroutineScope.launch {
                listState.scrollToItem(messages.value.lastIndex)
            }
        }
        onDispose { }
    }


    Column {
        ChatAppBar(viewModel = viewModel) {}
        ChatList(viewModel = viewModel, listState = listState, messages = messages)
        ChatBottomBar(viewModel = viewModel, chatUid = chatUid, listState = listState)
    }

}
