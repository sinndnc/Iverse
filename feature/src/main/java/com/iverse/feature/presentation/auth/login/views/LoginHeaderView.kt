package com.iverse.feature.presentation.auth.login.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.navigation.NavController
import com.iverse.feature.R
import com.iverse.feature.component.icon.CustomIconButton
import com.iverse.feature.component.text.HeaderText

//HEADER VIEW
@Composable
 fun LoginHeaderView(
    modifier: Modifier = Modifier,
    focus: FocusManager,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomIconButton(Icons.Default.ArrowBack) {
                focus.clearFocus()
                //TODO ONBOARD VIEW YAP BI ARA
                //navController.popBackStack(Screens.OnBoardUI.route, false)
            }
            CustomIconButton(Icons.Default.Settings) {
            }
        }
        HeaderText(R.string.welcome_text)
    }
}
