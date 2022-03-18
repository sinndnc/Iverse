package com.iverse.feature.presentation.main.pages.chat.chat_room.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.theme.Blue
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray

@Composable
fun MessageBubble(
    modifier: Modifier = Modifier,
    message: String,
    messageDate: String,
    isMyMessage: Boolean,
) {

    val bubbleAlignment = if (isMyMessage) Alignment.CenterEnd else Alignment.CenterStart
    val bubbleHorizontalAlignment = if (isMyMessage) Alignment.End else Alignment.Start
    val bubbleBackground = if (isMyMessage) Blue.p400 else Gray.p300
    val textColor = if (isMyMessage) Color.White else Gray.p800

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = bubbleAlignment
    ) {
        val maxBubbleWidth = maxWidth * 0.9F
        Column(
            modifier = Modifier.width(maxBubbleWidth),
            horizontalAlignment = bubbleHorizontalAlignment,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = message,
                color = textColor,
                modifier = Modifier
                    .clip(CustomSmallShapes.medium)
                    .background(bubbleBackground)
                    .padding(5.dp)
            )
            Text(
                text = messageDate,
                style = MaterialTheme.typography.overline,
                modifier = Modifier.wrapContentSize(bubbleAlignment)
            )
        }

    }
}