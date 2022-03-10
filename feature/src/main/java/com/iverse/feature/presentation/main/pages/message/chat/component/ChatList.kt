package com.iverse.feature.presentation.main.pages.message.chat.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iverse.core.domain.model.auth.login.Message

@Composable
fun ColumnScope.ChatList(listState: LazyListState, messageList: List<Message>) {
    LazyColumn(
        modifier = Modifier.weight(1F),
        state = listState,
        reverseLayout = true,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(items = messageList) { index, item ->
            /*
            if (index == 0) {
                Text(
                    "Today",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
             */
            MessageBubble(
                message = item.message,
                messageDate = item.date,
                isMyMessage = item.isMy,
            )
        }
    }
}