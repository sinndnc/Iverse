package com.iverse.feature.component.button

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iverse.feature.R
import com.iverse.feature.component.theme.CustomSmallShapes


@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    text: Int,
    isLoading: MutableState<Boolean> = mutableStateOf(false),
    onClicked: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp),
        shape = CustomSmallShapes.medium,
        onClick = {
            isLoading.value = true
            onClicked()
        }) {
        if (isLoading.value) CircularProgressIndicator() else Text(text = stringResource(text), color = Color.White)
    }

}

@Preview
@Composable
fun LoginButtonPreview() {
    LoginButton(text = R.string.login_text) {
    }
}