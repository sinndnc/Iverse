package com.iverse.feature.component.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.iverse.feature.R
import com.iverse.feature.component.box.PointBox
import com.iverse.feature.component.image.CircleImage
import com.iverse.feature.component.text.CustomText
import com.iverse.feature.component.theme.Blue

@Composable
fun MessageItem(
    username: String,
    message: String,
    profileImage: String,
    isMessaged: Boolean = true,
    onClicked: () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    val materialTheme = MaterialTheme.colors

    Row(
        modifier = Modifier
            .height(screenHeightDp.dp * 0.1F)
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
    Divider(color = materialTheme.onPrimary)

}
