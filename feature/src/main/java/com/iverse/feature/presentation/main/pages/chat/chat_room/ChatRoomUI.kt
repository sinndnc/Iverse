package com.iverse.feature.presentation.main.pages.chat.chat_room

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.iverse.feature.presentation.main.pages.chat.chat_room.component.ChatAppBar
import com.iverse.feature.presentation.main.pages.chat.chat_room.component.ChatBottomBar
import com.iverse.feature.presentation.main.pages.chat.chat_room.component.ChatList


@Composable
fun ChatUI(navController: NavController, roomViewModel: ChatRoomViewModel, image: String, name: String) {

    val listState = rememberLazyListState()
    //val messages = roomViewModel.messages.collectAsState()

    Column {
        ChatAppBar(image = image, name = name) { navController.navigateUp() }
        ChatList(listState = listState, )
        ChatBottomBar(roomViewModel = roomViewModel)
    }


}