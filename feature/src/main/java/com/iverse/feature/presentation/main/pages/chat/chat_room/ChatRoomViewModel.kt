package com.iverse.feature.presentation.main.pages.chat.chat_room

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.iverse.core.domain.model.Chat
import com.iverse.core.domain.model.Message
import com.iverse.core.domain.repository.chatRoom.ChatRoomRepository
import com.iverse.core.utils.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val chatRoomRepository: ChatRoomRepository,
    val firebaseAuth: FirebaseAuth,
) : ViewModel() {

    val currentUserInfo = firebaseAuth.currentUser!!

    private val _messages = MutableStateFlow(listOf<Message>())
    val messages: StateFlow<List<Message>> = _messages

    private val _chatRoomInfo = MutableStateFlow(Chat())
    val chatRoomInfo: StateFlow<Chat> = _chatRoomInfo

    private val uiState = mutableStateOf<UiState>(UiState.Loading)

    private val _itemState = mutableStateListOf<Boolean>()
    val itemState: SnapshotStateList<Boolean> = _itemState


    fun getChatRoomMessages(chatUid: String) {
        chatRoomRepository.getChatRooms(chatUid).addSnapshotListener { snapshot, error ->
            if (snapshot != null && snapshot.exists()) {
                val chat = snapshot.toObject(Chat::class.java)!!
                _chatRoomInfo.value = chat

                val messages = getAllMessages(chat.messages!!)
                _messages.value = messages
                uiState.value = UiState.Success
            }
        }

    }

    /**
     * @return reversed List<[Message]>
     */
    private fun getAllMessages(rawMessageData: List<Message>): List<Message> {
        val messages = mutableListOf<Message>()

        for (message in rawMessageData) {
            if (!message.isDeleted) {
                messages.add(message)
                _itemState.add(false)
            }
        }
        return messages
    }


    fun onSendMessage(chatRoomUid: String, message: Message) {

        chatRoomRepository.sendMessageToChatRoom(chatRoomUid, message)

    }

    fun changeSelectedItemState(index: Int) {
        if (uiState.value == UiState.OnProgress) {
            uiState.value = UiState.OnProgress
            _itemState[index] = !_itemState[index]
        }

    }


}