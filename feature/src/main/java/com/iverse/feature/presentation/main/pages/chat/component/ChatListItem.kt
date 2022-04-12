package com.iverse.feature.presentation.main.pages.chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.iverse.core.domain.model.Chat
import com.iverse.core.domain.model.ChatType
import com.iverse.feature.component.box.PointBox
import com.iverse.feature.component.image.CircleImage
import com.iverse.feature.component.image.GroupCircleImage
import com.iverse.feature.component.text.CustomText
import kotlinx.coroutines.launch

private enum class SwipeDirectionState { LEFT, RIGHT, MIDDLE }


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChatItem(
    modifier: Modifier = Modifier,
    position: Int,
    chat: Chat,
    onDeleted: () -> Unit,
    onArchived: () -> Unit,
    onClicked: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val materialTheme = MaterialTheme.colors
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightDp = configuration.screenHeightDp.dp
    val maxWidth = with(LocalDensity.current) { screenWidthDp.toPx() }
    val swipeableState = rememberSwipeableState(initialValue = SwipeDirectionState.MIDDLE)
    val swipeableLeftStateOffset = swipeableState.offset.value / (maxWidth / 3F)
    val swipeableRightStateOffset = swipeableState.offset.value / -(maxWidth / 3F)
    val leftAnimation = Color.Red.copy(swipeableLeftStateOffset.coerceIn(0F, 1F))
    val rightAnimation = Color.DarkGray.copy(swipeableRightStateOffset.coerceIn(0F, 1F))

    val color = when (swipeableState.direction) {
        1f -> leftAnimation      //LEFT TO RIGHT
        -1f -> rightAnimation     //RIGHT TO LEFT
        else -> Color.Transparent
    }

    if (swipeableState.isAnimationRunning) {
        DisposableEffect(Unit) {
            onDispose {
                when (swipeableState.currentValue) {
                    SwipeDirectionState.RIGHT -> onDeleted()
                    SwipeDirectionState.LEFT -> onArchived()
                    else -> return@onDispose
                }
                scope.launch {
                    swipeableState.animateTo(SwipeDirectionState.MIDDLE)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeightDp * 0.1F)
            .background(color)
            .onSizeChanged { Size(it.width.toFloat(), it.height.toFloat()) }
            .swipeable(
                state = swipeableState,
                orientation = Orientation.Horizontal,
                thresholds = { _, _ -> FractionalThreshold(1F) },
                anchors = mapOf(
                    0f to SwipeDirectionState.MIDDLE,
                    maxWidth / 2.5F to SwipeDirectionState.RIGHT,
                    -(maxWidth / 2.5F) to SwipeDirectionState.LEFT
                ),
            )
            .offset { IntOffset(swipeableState.offset.value.toInt(), 0) }
    ) {
        if (chat.chatType == ChatType.Private.name) {
            OneToOneChatCard(
                userName = chat.chatName,
                lastMessageText = chat.lastMessageText!!,
                hasMessage = false,
                onClicked = { onClicked() }
            )
        } else if (chat.chatType == ChatType.Group.name) {
            GroupChatCard(
                chatName = chat.chatName,
                lastMessageText = chat.lastMessageText!!,
                hasMessage = true,
                lastMessageUserName = "Sindnnc",
                onClicked = { onClicked() }
            )
        }

    }
    Divider(color = materialTheme.onPrimary)
}

@Composable
private fun OneToOneChatCard(
    userName: String,
    hasMessage: Boolean,
    lastMessageText: String,
    userImage: String = "",
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .clickable { onClicked() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CircleImage("https://firebasestorage.googleapis.com/v0/b/main-tokenizer-339209.appspot.com/o/profile_photo.jpg?alt=media&token=80ff4514-2192-43c3-8ad8-d83e16f9cd81")
        Spacer(modifier = Modifier.weight(0.025F))
        Column(
            modifier = Modifier.weight(0.7F),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomText(
                text = userName,
                style = MaterialTheme.typography.subtitle1,
                textOverflow = TextOverflow.Ellipsis
            )
            CustomText(
                text = lastMessageText,
                style = MaterialTheme.typography.h1,
                textOverflow = TextOverflow.Ellipsis,
            )
        }
        Spacer(modifier = Modifier.weight(0.025F))
        if (hasMessage) PointBox(size = 10.dp, color = MaterialTheme.colors.primary)
    }
}

@Composable
private fun GroupChatCard(
    hasMessage: Boolean,
    chatName: String,
    groupImage: String = "",
    lastMessageText: String,
    lastMessageUserName: String,
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .clickable { onClicked() }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        GroupCircleImage(
            modifier = Modifier.weight(0.12F),
            image1 = "",
            image2 = "",
            size = 33.dp,
        )
        Spacer(modifier = Modifier.weight(0.025F))
        Column(
            modifier = Modifier.weight(0.7F),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomText(
                text = chatName,
                style = MaterialTheme.typography.subtitle1,
                textOverflow = TextOverflow.Ellipsis
            )
            Row {
                CustomText(
                    text = "$lastMessageUserName: ",
                    style = MaterialTheme.typography.h1,
                    textOverflow = TextOverflow.Ellipsis,
                )
                CustomText(
                    text = lastMessageText,
                    style = MaterialTheme.typography.h1,
                    textOverflow = TextOverflow.Ellipsis,
                )
            }

        }
        Spacer(modifier = Modifier.weight(0.025F))
        if (hasMessage) PointBox(size = 10.dp, color = MaterialTheme.colors.primary)
    }
}
