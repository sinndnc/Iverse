package com.iverse.feature.presentation.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.usecase.shuffle.GetUserShuffleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserShuffleListUseCase: GetUserShuffleListUseCase
) : ViewModel() {

    val userList = mutableStateListOf<Chat>()

    init {
        viewModelScope.launch { userList.addAll(getUserShuffleListUseCase.invoke().toMutableList()) }
    }

}