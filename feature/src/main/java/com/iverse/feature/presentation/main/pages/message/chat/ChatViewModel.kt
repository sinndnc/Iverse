package com.iverse.feature.presentation.main.pages.message.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.auth.login.Message
import com.iverse.core.domain.repository.message.MessageRepository
import com.iverse.core.domain.repository.shuffle.ShuffleRepository
import com.iverse.core.domain.usecase.message.FetchMessageListUseCase
import com.iverse.core.domain.usecase.shuffle.GetUserShuffleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(fetchMessageListUseCase: FetchMessageListUseCase) : ViewModel() {

    val messageList = mutableStateListOf<Message>()

    init {
        viewModelScope.launch { messageList.addAll(fetchMessageListUseCase.invoke("60bcfaf69c7e4d1ff801d0d4").toMutableList()) }
    }
}