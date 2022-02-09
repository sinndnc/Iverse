package com.iverse.feature.presentation.auth.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iverse.feature.R
import com.iverse.feature.component.icon.LoginIconButton
import com.iverse.feature.presentation.auth.login.LoginViewModel
import com.iverse.feature.presentation.auth.login.options.SignInWithGoogleButton

@Composable
fun LoginBottomView(modifier: Modifier = Modifier, viewModel: LoginViewModel) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        //TODO ADD TO GOOGLE,FACEBOOK etc. INTEGRATION
        SignInWithGoogleButton(viewModel = viewModel)
        LoginIconButton(R.drawable.apple_logo) {}
        LoginIconButton(R.drawable.twitter_logo) {}
        LoginIconButton(R.drawable.gihub_logo) {}
    }
}
