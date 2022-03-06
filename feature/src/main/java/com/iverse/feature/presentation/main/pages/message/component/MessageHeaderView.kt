package com.iverse.feature.presentation.main.pages.message.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.iverse.feature.component.appBar.CollapsingBar
import com.iverse.feature.presentation.main.pages.message.MessageViewModel

@Composable
fun MessageHeaderView(viewModel: MessageViewModel, scrollState: ScrollState) {
    Column {
        CollapsingBar(
            scrollState,
            onClickedFirstButton = {},
            onClickedSecondButton = {},
        )
        Divider(color = MaterialTheme.colors.onPrimary)
    }
}