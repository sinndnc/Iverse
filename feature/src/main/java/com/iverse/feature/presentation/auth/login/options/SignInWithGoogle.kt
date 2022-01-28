package com.iverse.feature.presentation.auth.login.options

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.iverse.feature.R
import com.iverse.feature.component.icon.LoginIconButton
import com.iverse.feature.presentation.auth.login.LoginViewModel
import timber.log.Timber

@Composable
fun SignInWithGoogleButton(viewModel: LoginViewModel) {

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        when (it.resultCode) {
            Activity.RESULT_OK -> {
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                val result = task.result
                Timber.d(
                    " " + result.email + "  *  " + result.account + " *  " + result.displayName + " * " +
                            " " + result.givenName + " *  " + result.familyName + " *  " + result.id +
                            "  *  " + result.grantedScopes + "  *  " + result.idToken + "  *  "
                            + result.isExpired + " " + "*  " + result.serverAuthCode
                )
                return@rememberLauncherForActivityResult
            }
            Activity.RESULT_CANCELED -> {
                Timber.d("GoogleTest", "request is Cancelled")
            }
            Activity.RESULT_FIRST_USER -> {
                Timber.d("GoogleTest", "request is first user")

            }
        }
    }

    LoginIconButton(R.drawable.google_logo) {
        viewModel.signInWithGoogle(googleSignInLauncher)
    }
}