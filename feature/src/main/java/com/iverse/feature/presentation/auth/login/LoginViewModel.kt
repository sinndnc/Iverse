package com.iverse.feature.presentation.auth.login

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.iverse.core.base.Status
import com.iverse.core.data.entities.auth.login.LoginRequestModel
import com.iverse.core.data.remote.auth.login.LoginRemoteService
import com.iverse.core.utils.qualifiers.SignUp
import com.iverse.feature.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val googleClient: GoogleSignInClient,
    private val loginService: LoginRemoteService
) : ViewModel() {
    val isLoading = mutableStateOf(false)

    //************ EMAIL SIGN IN ************
    //TODO ADD STORAGE MANAGER FOR SAVE TOKEN AND etc.
    fun signInWithEmail(loginRequestModel: LoginRequestModel, navController: NavController) {
        isLoading.value = true
        viewModelScope.launch {
            val response = loginService.loginToAccount(loginRequestModel)
            when (response.status) {
                Status.ERROR -> {
                    //TODO SHOW POP UP TO FOR WRONG LOGIN INFO
                    isLoading.value = false
                }
                Status.SUCCESS -> {
                    isLoading.value = false
                    navController.navigate(route = Screens.HomeUI.route) {
                        popUpTo(Screens.LoginUI.route) { inclusive = true }
                    }
                }
                else -> isLoading.value = false
            }
        }

    }


    //************ GOOGLE SIGN IN ************
    fun signInWithGoogle(launcher: ManagedActivityResultLauncher<Intent, ActivityResult>) {
        isLoading.value = true
        launcher.launch(googleClient.signInIntent)
        isLoading.value = false
    }


    //************ GITHUB SIGN IN *************
    fun signInWithGithub() {}



}

