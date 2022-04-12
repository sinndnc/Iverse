package com.iverse.feature.presentation.main.pages.chat.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.iverse.core.utils.state.UiState
import com.iverse.feature.component.view.ArchivedChatItem
import com.iverse.feature.presentation.main.pages.chat.ChatViewModel


@Composable
fun ColumnScope.ChatBodyView(viewModel: ChatViewModel) {

    val state = viewModel.uiState
    val chats = viewModel.chats.collectAsState()
    val archivedChats = viewModel.archivedChats.collectAsState()
    val hasArchivedChat = archivedChats.value.isNotEmpty()

    if (state.value is UiState.Loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.Black)
        }
    } else if (state.value is UiState.Success) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                ArchivedChatItem(
                    hasArchivedChat = hasArchivedChat,
                    value = archivedChats.value.size
                ) {
                    //TODO
                    viewModel.addRoomToArchive(archivedChats.value[0], false)
                }
            }
            itemsIndexed(chats.value) { position, chat ->
                ChatItem(
                    chat = chat,
                    position = position,
                    onDeleted = { },
                    onArchived = { viewModel.addRoomToArchive(chat, true) },
                    onClicked = { viewModel.navigateToChatRoom(chat.chatUid!!) }
                )
            }
        }
    }
}