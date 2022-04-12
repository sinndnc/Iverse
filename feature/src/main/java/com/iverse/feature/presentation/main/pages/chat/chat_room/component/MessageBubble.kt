package com.iverse.feature.presentation.main.pages.chat.chat_room.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.PressGestureScope
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.iverse.core.domain.model.Message
import com.iverse.feature.component.theme.Blue
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray
import com.iverse.feature.presentation.main.pages.chat.chat_room.ChatRoomViewModel

@Composable
fun MessageBubble(
    index: Int,
    item: Message,
    modifier: Modifier,
    isMyMessage: Boolean,
    onTap: (Offset) -> Unit?,
    viewModel: ChatRoomViewModel,
    onLongPress: (Offset) -> Unit?,
    onDoubleTop: (Offset) -> Unit?,
    onPress: suspend PressGestureScope.(Offset) -> Unit,
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val messageAlignment = if (isMyMessage) Alignment.CenterEnd else Alignment.CenterStart
    val backGroundColor by animateColorAsState(
        targetValue = if (viewModel.itemState[index]) Color.LightGray else Color.White,
        animationSpec = tween(durationMillis = 50)
    )

    BoxWithConstraints(
        modifier = modifier
            .width(screenWidth)
            .background(backGroundColor)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { onPress(it) },
                    onDoubleTap = { onDoubleTop(it) },
                    onLongPress = { onLongPress(it) },
                    onTap = { onTap(it) }
                )
            }
            .padding(vertical = 1.dp, horizontal = 4.dp),
        contentAlignment = messageAlignment
    ) {
        if (isMyMessage) MyMessageBubble(message = item.message)
        else OtherMessageBubble(message = item.message)
    }
}



@Composable
private fun BoxWithConstraintsScope.MyMessageBubble(message: String) {
    val maxBubbleWidth = maxWidth * 0.8F

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = message, color = Color.White,
            modifier = Modifier
                .widthIn(max = maxBubbleWidth)
                .clip(CustomSmallShapes.medium)
                .background(Blue.p400)
                .padding(horizontal = 4.dp,vertical = 2.dp),
        )

    }
}


@Composable
private fun BoxWithConstraintsScope.OtherMessageBubble(message: String) {
    val maxBubbleWidth = maxWidth * 0.8F
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = message, color = Gray.p800,
            modifier = Modifier
                .widthIn(max = maxBubbleWidth)
                .clip(CustomSmallShapes.medium)
                .background(Gray.p400)
                .padding(horizontal = 4.dp,vertical = 2.dp),
        )
    }
}