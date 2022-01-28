package com.iverse.feature.component.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.iverse.feature.R
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray
import com.iverse.feature.extensions.noRippleClickable


@Composable
fun CustomBasicTextField(
    value: MutableState<String>,
    isEnabled: Boolean = true,
    placeHolder: String,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    trailingIcon: Int,
    onClicked: () -> Unit,
) {
    //TODO BURADAKI RENKLER MATERIAL THEME'E BAĞLANACAK
    TextField(
        value = value.value,
        onValueChange = { value.value = it },
        enabled = isEnabled,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Gray.p900,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        trailingIcon = {
            if (value.value.isNotEmpty()) {
                Icon(painterResource(id = trailingIcon), "trailing icon",
                    modifier = Modifier.noRippleClickable { onClicked() })
            }
        },
        placeholder = { Text(placeHolder) },
        shape = CustomSmallShapes.medium,
        singleLine = true,
    )


}

@Preview
@Composable
fun BasicTextFieldPreview() {
    val value: MutableState<String> = remember { mutableStateOf("") }
    CustomBasicTextField(
        value = value,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default,
        trailingIcon = R.drawable.visible,
        placeHolder = "Email"
    ){}
}