package com.iverse.feature.component.appBar

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.iverse.feature.R
import com.iverse.feature.component.icon.ClipIcon
import com.iverse.feature.component.text.HeaderText
import com.iverse.feature.component.textfield.CustomSearchTextField
import com.iverse.feature.component.theme.Gray
import kotlin.math.min

@Composable
fun CollapsingBar(scrollState: ScrollState, onClickedFirstButton: () -> Unit, onClickedSecondButton: () -> Unit) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    val collapseRange = (screenHeightDp / 2).toFloat()
    val collapseFraction = (scrollState.maxValue / collapseRange).coerceIn(0f, 1f)
    val maxOffset = (screenHeightDp * 0.07F).toInt()
    val minOffset = min(maxOffset, scrollState.value)
    val textY = lerp(start = maxOffset, stop = minOffset, fraction = collapseFraction)

    Column(
        modifier = Modifier
            .fillMaxHeight(0.2F)
            .padding(screenWidthDp.dp * 0.025F),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeaderText(
                modifier = Modifier.weight(1F),
                text = R.string.message_text
            )
            ClipIcon(icon = Icons.Rounded.Edit, Gray.p300) { onClickedFirstButton() }
            Spacer(modifier = Modifier.width(20.dp))
            ClipIcon(icon = Icons.Rounded.Edit, Gray.p300) { onClickedSecondButton() }
        }
        CustomSearchTextField(placeholderText = "Search")
    }


}