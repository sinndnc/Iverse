package com.iverse.feature.screens.auth.login

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.iverse.feature.presentation.auth.LoginViewModel


@Composable
fun LoginUI(
    navController: NavController,
    loginViewModel: LoginViewModel
) {

/*
    var email by remember { mutableStateOf("") }
    var displayName by remember { mutableStateOf("") }
    val authResultLauncher = rememberLauncherForActivityResult(contract = GoogleResultContract())
    { task ->
        try {
            val gso = task?.getResult(ApiException::class.java)
            if (gso != null) {
                email = gso.email.toString()
                displayName = gso.displayName.toString()
            }
        } catch (e: ApiException) {
        }
    }
 */
    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) {
        if (it.resultCode != Activity.RESULT_OK) {
            return@rememberLauncherForActivityResult
        }
        val credential = loginViewModel.getCredential(it.data)

        Log.d(
            "GoogleTest",
            "${credential.displayName}  *  ${credential.password} " +
                    "  * ${credential.familyName}" +
                    "  * ${credential.givenName}  * ${credential.id}  *  ${credential.googleIdToken}"
        )
    }
    val googleSignUpLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) {
        if (it.resultCode != Activity.RESULT_OK) {
            return@rememberLauncherForActivityResult
        }
        val credential = loginViewModel.getCredential(it.data)

        Log.d(
            "GoogleTest",
            "${credential.displayName}  *  ${credential.password} " +
                    "  * ${credential.familyName}" +
                    "  * ${credential.givenName}  * ${credential.id}  *  ${credential.googleIdToken}"
        )
    }

    val googleSignInMethod = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode != Activity.RESULT_OK) {
            return@rememberLauncherForActivityResult
        }
        val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        Log.d("GoogleTest", task.result.toString())

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { googleSignInMethod.launch(loginViewModel.googleClient.signInIntent) }) {
            Text(text = "Google Login")
        }
    }
}
