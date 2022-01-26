package com.iverse.android.di

import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.iverse.android.R
import com.iverse.core.utils.qualifiers.SignIn
import com.iverse.core.utils.qualifiers.SignUp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GoogleModule {

    //GOOGLE SIGN IN METHOD

    @Provides
    @Singleton
    fun provideGoogleSignInOptions(): GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()


    @Provides
    @Singleton
    fun provideGoogleSignInMethod(@ApplicationContext context: Context, gso: GoogleSignInOptions)
            : GoogleSignInClient = GoogleSignIn.getClient(context, gso);


    //GOOGLE ONE TAP SIGN IN AND SIGN UP

    @Provides
    @Singleton
    fun provideSignInClient(@ApplicationContext context: Context)
            : SignInClient = Identity.getSignInClient(context)

    @Provides
    @Singleton
    fun provideServerWebId(@ApplicationContext context: Context): String =
        context.getString(R.string.google_api_web_token)


    @SignIn
    @Provides
    @Singleton
    fun provideSignInRequest(clientId: String): BeginSignInRequest = BeginSignInRequest.builder()
        .setPasswordRequestOptions(
            BeginSignInRequest.PasswordRequestOptions.builder()
                .setSupported(true)
                .build()
        )
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(clientId)
                .setFilterByAuthorizedAccounts(true)
                .build()
        )
        .setAutoSelectEnabled(true)
        .build()


    @SignUp
    @Provides
    @Singleton
    fun provideSignUpRequest(clientId: String): BeginSignInRequest = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(clientId)
                .setFilterByAuthorizedAccounts(false)
                .build()
        )
        .build()

}

