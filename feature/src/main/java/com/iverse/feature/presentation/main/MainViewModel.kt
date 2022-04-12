package com.iverse.feature.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import com.iverse.core.domain.model.User
import com.iverse.core.domain.repository.user.UserRepository
import com.iverse.core.utils.qualifiers.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    private val firebaseMessaging: FirebaseMessaging,
) : ViewModel() {

    init {
        getCurrentUserData()
    }

    private fun getCurrentUserData() {
        firebaseMessaging.token.addOnCompleteListener {
            Log.d("FCMtoken",it.result)
        }
    }
}