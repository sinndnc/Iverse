package com.iverse.feature.presentation.auth.splash


import androidx.lifecycle.ViewModel
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val storageManager: StorageManager
) : ViewModel() {

    val isToken: Flow<String> = runBlocking(Dispatchers.IO) { storageManager.readStringData(AuthPreferencesKeys.TOKEN) }


}