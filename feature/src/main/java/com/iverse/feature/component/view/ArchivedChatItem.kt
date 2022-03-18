package com.iverse.feature.component.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.iverse.feature.R

@Composable
fun ArchivedChatItem(
    modifier: Modifier = Modifier,
    hasArchivedChat: Boolean,
    value: Int,
    onClicked: () -> Unit,
) {
    AnimatedVisibility(
        visible = hasArchivedChat,
        modifier = modifier,
        enter = slideInVertically(
            animationSpec = tween(durationMillis = 500),
            initialOffsetY = { -(it * 1.5.toInt()) }
        ),
        exit = slideOutVertically(
            animationSpec = tween(durationMillis = 500),
            targetOffsetY = { -(it * 1.5.toInt()) }
        ),
    ) {
        Box(modifier = Modifier.clickable { onClicked::class.java }) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Icon(painter = painterResource(R.drawable.archive), contentDescription = "Archived Item")
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = "Archived Chats", modifier = Modifier.weight(1F), textAlign = TextAlign.Start)
                Text(text = "$value")
            }
            Divider(color = MaterialTheme.colors.onPrimary, modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}