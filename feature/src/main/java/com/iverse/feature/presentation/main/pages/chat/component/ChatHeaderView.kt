package com.iverse.feature.presentation.main.pages.chat.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.iverse.feature.component.appBar.CollapsingBar
import com.iverse.feature.presentation.main.pages.chat.ChatViewModel

@Composable
fun MessageHeaderView(viewModel: ChatViewModel) {
    Column {
        CollapsingBar(
            rememberScrollState(),
            onClickedFirstButton = {},
            onClickedSecondButton = {},
        )
        Divider(color = MaterialTheme.colors.onPrimary)
    }
}