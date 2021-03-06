package com.iverse.feature.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray
import com.iverse.feature.extensions.noRippleClickable


@Composable
fun CustomBasicTextField(
    value: MutableState<String>,
    isEnabled: Boolean,
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
        enabled = !isEnabled,
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
        placeholder = { Text(placeHolder, style = MaterialTheme.typography.subtitle2) },
        shape = CustomSmallShapes.medium,
        singleLine = true,
    )


}

