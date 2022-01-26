package com.iverse.feature.presentation.auth

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.iverse.core.utils.qualifiers.SignIn
import com.iverse.core.utils.qualifiers.SignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInClient: SignInClient,
    @SignIn private val signInRequest: BeginSignInRequest,
    @SignUp private val signUpRequest: BeginSignInRequest,
    val googleClient: GoogleSignInClient
) : ViewModel() {

    //GOOGLE ONE TAP SIGN IN AND SIGN UP

    fun getCredential(data: Intent?) = signInClient.getSignInCredentialFromIntent(data)

    fun signInWithGoogle(launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) {
        signInClient.beginSignIn(signInRequest).addOnSuccessListener { result ->
            try {
                launcher.launch(IntentSenderRequest.Builder(result.pendingIntent.intentSender).build())
            } catch (e: Exception) {

            }
        }
    }

    fun signUpWithGoogle(launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) {
        signInClient.beginSignIn(signUpRequest).addOnSuccessListener { result ->
            try {
                launcher.launch(IntentSenderRequest.Builder(result.pendingIntent.intentSender).build())
            } catch (e: Exception) {

            }
        }
    }


}

