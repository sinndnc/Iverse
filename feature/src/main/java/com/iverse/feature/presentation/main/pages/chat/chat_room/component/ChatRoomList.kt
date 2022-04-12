package com.iverse.feature.presentation.main.pages.chat.chat_room.component


import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.iverse.core.domain.model.Message
import com.iverse.feature.extensions.horizontalDraggable
import com.iverse.feature.presentation.main.pages.chat.chat_room.ChatRoomViewModel
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun ColumnScope.ChatList(
    viewModel: ChatRoomViewModel,
    messages: State<List<Message>>,
    listState: LazyListState,
) {
    val coroutineScope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val offsetX = remember { Animatable(0f) }
    val maxWidth = with(LocalDensity.current) { screenWidth.toPx() }
    val draggableMaxWidth = maxWidth * 0.15F
    val textDraggableWidth = maxWidth * 0.13F
    val state = rememberDraggableState(onDelta = { delta -> coroutineScope.launch { offsetX.snapTo(offsetX.value + delta) } })


    LazyColumn(
        modifier = Modifier
            .weight(1f)
            .horizontalDraggable(state, offsetX),
        state = listState,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        itemsIndexed(messages.value) { index, item ->
            val isMyMessage = item.senderId == viewModel.currentUserInfo.uid
            val timeAlignment = if (isMyMessage) Alignment.CenterEnd else Alignment.CenterStart
            val timeOffset = if (isMyMessage) textDraggableWidth else -textDraggableWidth

            Box(
                modifier = Modifier.offset {
                    IntOffset(
                        offsetX.value
                            .coerceIn(-draggableMaxWidth, draggableMaxWidth)
                            .roundToInt(), 0
                    )
                }
            ) {
                MessageBubble(
                    item = item,
                    index = index,
                    modifier = Modifier,
                    viewModel = viewModel,
                    isMyMessage = isMyMessage,
                    onTap = { viewModel.changeSelectedItemState(index) },
                    onPress = {},
                    onLongPress = { viewModel.changeSelectedItemState(index) },
                    onDoubleTop = {},
                )
                Text(
                    text = "23.45 PM",
                    style = MaterialTheme.typography.caption,
                    color = Color.Black,
                    modifier = Modifier
                        .align(timeAlignment)
                        .offset { IntOffset((timeOffset).roundToInt(), 0) }
                )
            }
        }
    }
}
