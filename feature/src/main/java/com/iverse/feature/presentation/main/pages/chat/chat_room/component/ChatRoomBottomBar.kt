package com.iverse.feature.presentation.main.pages.chat.chat_room.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iverse.core.domain.model.Message
import com.iverse.feature.R
import com.iverse.feature.component.theme.CustomMediumShapes
import com.iverse.feature.presentation.main.pages.chat.chat_room.ChatRoomViewModel
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun ChatBottomBar(viewModel: ChatRoomViewModel, chatUid: String, listState: LazyListState) {

    val materialTheme = MaterialTheme.colors
    val text = remember { mutableStateOf("") }
    val isTextHas by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (isTextHas && text.value.isNotEmpty()) materialTheme.primary
        else materialTheme.onSurface
    )

    Row(
        modifier = Modifier.imePadding(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        ChatTextField(text = text)
        IconButton(
            onClick = {
                viewModel.onSendMessage(chatUid, Message(text.value))
            },
            modifier = Modifier
                .padding(4.dp)
                .clip(CustomMediumShapes.medium)
                .background(color)
        ) {
            Icon(
                painterResource(R.drawable.arrow_up),
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }

}

