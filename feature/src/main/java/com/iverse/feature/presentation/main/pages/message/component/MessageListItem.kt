package com.iverse.feature.presentation.main.pages.message.component

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
import com.iverse.feature.component.box.PointBox
import com.iverse.feature.component.image.CircleImage
import com.iverse.feature.component.text.CustomText
import kotlinx.coroutines.launch

private enum class SwipeDirectionState { LEFT, RIGHT, MIDDLE }


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MessageItem(
    username: String,
    message: String,
    profileImage: String,
    isMessaged: Boolean = true,
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
    val swipeableLeftStateOffset = swipeableState.offset.value / (maxWidth / 2F)
    val swipeableRightStateOffset = swipeableState.offset.value / -(maxWidth / 2F)
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
            .background(color)
            .onSizeChanged { Size(it.width.toFloat(), it.height.toFloat()) }
            .swipeable(
                state = swipeableState,
                orientation = Orientation.Horizontal,
                thresholds = { _, _ -> FractionalThreshold(0.85F) },
                anchors = mapOf(
                    0f to SwipeDirectionState.MIDDLE,
                    maxWidth / 2.5F to SwipeDirectionState.RIGHT,
                    -(maxWidth / 2.5F) to SwipeDirectionState.LEFT
                ),
            )
            .offset { IntOffset(swipeableState.offset.value.toInt(), 0) }
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .height(screenHeightDp * 0.1F)
                .clickable { onClicked() }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CircleImage(profileImage)
            Spacer(modifier = Modifier.weight(0.025F))
            Column(
                modifier = Modifier.weight(0.7F),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                CustomText(
                    text = "@$username",
                    style = MaterialTheme.typography.subtitle1,
                    textOverflow = TextOverflow.Ellipsis
                )
                CustomText(
                    text = message,
                    style = MaterialTheme.typography.h1,
                    textOverflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.weight(0.025F))
            if (isMessaged) PointBox(size = 10.dp, color = materialTheme.primary)
        }
    }
    Divider(color = materialTheme.onPrimary)
}
