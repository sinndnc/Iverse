package com.iverse.feature.presentation.main.pages.chat.chat_room.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.sharp.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.icon.ClipIcon
import com.iverse.feature.component.image.CircleImage
import com.iverse.feature.extensions.noRippleClickable
import com.iverse.feature.presentation.main.pages.chat.chat_room.ChatRoomViewModel

@Composable
fun ChatAppBar(modifier: Modifier = Modifier, viewModel: ChatRoomViewModel, onClicked: () -> Unit) {

    val configuration = LocalConfiguration.current
    val barHeight = (configuration.screenHeightDp.dp * 0.1F)
    val chatRoomInfo = viewModel.chatRoomInfo.collectAsState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(barHeight)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Rounded.ArrowBack,
            contentDescription = null,
            modifier = Modifier.noRippleClickable { onClicked() })
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleImage(image = chatRoomInfo.value.chatImage, size = 35.dp)
            Text(chatRoomInfo.value.chatName, style = MaterialTheme.typography.overline)
        }
        ClipIcon(icon = Icons.Sharp.Info, backgroundColor = Color.LightGray) {

        }
    }
    Divider(color = MaterialTheme.colors.onPrimary)
}