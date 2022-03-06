package com.iverse.feature.presentation.auth.login.options

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.iverse.feature.R
import com.iverse.feature.component.icon.LoginIconButton
import com.iverse.feature.presentation.auth.login.LoginViewModel

@Composable
fun SignInWithGoogleButton(viewModel: LoginViewModel) {

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        when (it.resultCode) {
            Activity.RESULT_OK -> {
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                //TODO ADD STORAGE MANAGER FOR DATA
                val result = task.result
                return@rememberLauncherForActivityResult
            }
            Activity.RESULT_CANCELED -> {
                Log.d("GoogleTest", "request is Cancelled")
            }
            Activity.RESULT_FIRST_USER -> {
                Log.d("GoogleTest", "request is first user")

            }
        }
    }

    LoginIconButton(R.drawable.google_logo) {}
}