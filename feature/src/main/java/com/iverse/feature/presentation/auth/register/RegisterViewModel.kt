package com.iverse.feature.presentation.auth.register

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.iverse.core.utils.qualifiers.SignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val signInClient: SignInClient,
    @SignUp private val signUpRequest: BeginSignInRequest,
) : ViewModel() {


    fun getCredential(data: Intent?) = signInClient.getSignInCredentialFromIntent(data)
    fun signUpWithGoogle(launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) {
        signInClient.beginSignIn(signUpRequest).addOnSuccessListener { result ->
            try {
                launcher.launch(IntentSenderRequest.Builder(result.pendingIntent.intentSender).build())
            } catch (e: Exception) {

            }
        }
    }
}