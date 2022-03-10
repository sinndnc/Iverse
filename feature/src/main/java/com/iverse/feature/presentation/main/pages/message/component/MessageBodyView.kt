package com.iverse.feature.presentation.main.pages.message.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iverse.feature.presentation.main.MainViewModel
import com.iverse.feature.presentation.main.pages.message.MessageViewModel


@Composable
fun MessageBodyView(
    mainViewModel: MainViewModel,
    viewModel: MessageViewModel,
    scrollState: ScrollState,
    navController: NavController
) {

    val messageList = mainViewModel.userList

    if (messageList.isNullOrEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            messageList.forEach { chat ->
                MessageItem(
                    profileImage = chat._id.photo,
                    username = chat._id.username,
                    message = chat.messages.last().message,
                    onArchived = {},
                    onDeleted = {
                        //    messageList.remove(chat)
                    },
                    onClicked = {
                        viewModel.loginToConversation(
                            imageUrl = chat._id.photo,
                            receiverId = chat._id._id,
                            username = chat._id.username,
                            navController = navController
                        )
                    }
                )
            }
        }
    }
}