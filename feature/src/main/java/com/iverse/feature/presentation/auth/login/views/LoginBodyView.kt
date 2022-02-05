package com.iverse.feature.presentation.auth.login.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.feature.R
import com.iverse.feature.component.button.LoginButton
import com.iverse.feature.component.textfield.CustomBasicTextField
import com.iverse.feature.presentation.auth.login.LoginViewModel

//TODO EDIT THIS CLASS
@Composable
fun LoginBodyView(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
) {
    val emailValue: MutableState<String> = remember { mutableStateOf("") }
    val passwordValue: MutableState<String> = remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        //********* EMAIL **********
        CustomBasicTextField(
            value = emailValue,
            isEnabled = true,
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = R.drawable.close,
            placeHolder = "Email"
        ) { if (emailValue.value.isNotEmpty()) emailValue.value = "" }
        //******** PASSWORD *********
        CustomBasicTextField(
            value = passwordValue,
            isEnabled = true,
            visualTransformation = if (isVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = if (isVisible) R.drawable.visible else R.drawable.unvisible,
            placeHolder = "Password",
        ) { isVisible = !isVisible }
        //********** LOGIN ***********
        LoginButton(text = R.string.login_text, isEnabled = false) {
            viewModel.loginWithUseCase(LoginRequestModel("sinandinc333@gmail.com", "Snn20012004"))
        }
    }
}