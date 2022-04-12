package com.iverse.feature.extensions

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.launch

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun Modifier.horizontalDraggable(state: DraggableState, x: Animatable<Float, AnimationVector1D>): Modifier {
    return draggable(
        state = state,
        orientation = Orientation.Horizontal,
        onDragStopped = {
            launch {
                x.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 400,
                        delayMillis = 0
                    )
                )
            }
        },
    )
}

