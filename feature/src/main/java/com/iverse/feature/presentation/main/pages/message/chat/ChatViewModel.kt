package com.iverse.feature.presentation.main.pages.message.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.information.UserInfoService
import com.iverse.core.domain.model.auth.login.Message
import com.iverse.core.domain.usecase.message.FetchMessageListUseCase
import com.iverse.core.utils.socket.SocketService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val socketService: SocketService,
    private val userInfoService: UserInfoService,
    private val fetchMessageListUseCase: FetchMessageListUseCase
) : ViewModel() {

    private val _messageList = mutableStateListOf<Message>()
    val messageList: SnapshotStateList<Message> = _messageList
    lateinit var id: String

    init {
        viewModelScope.launch { id = userInfoService.getUserInformation(AuthPreferencesKeys.ID) }
        socketService.receiveMessage()
    }


    fun sendMessageToUser(text: String) {
        socketService.sendMessage(
            senderId = id,
            receiverId = "60bcfaf69c7e4d1ff801d0d4",
            message = text
        )
        messageList.add(
            Message(
                _id = id,
                date = "3/7/2022",
                isMy = true,
                message = text
            )
        )
    }
}