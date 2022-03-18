package com.iverse.feature.presentation.main.pages.chat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iverse.core.constant.FirestoreConstants
import com.iverse.core.domain.model.Chat
import com.iverse.core.domain.repository.chat.ChatRepository
import com.iverse.core.utils.qualifiers.IoDispatcher
import com.iverse.core.utils.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val chatRepository: ChatRepository
) : ViewModel() {

    /**
     * this variable is keeps chats owned by current user for this class
     */
    private val _chats = MutableStateFlow(listOf<Chat>())
    val chats: StateFlow<List<Chat>> = _chats

    private val _uiState = mutableStateOf<UiState>(UiState.Loading)
    val uiState: MutableState<UiState> = _uiState

    /**
     * this variable is keeps archived chats owned by current user for this class
     */
    private val _archivedChats = MutableStateFlow(listOf<Chat>())
    val archivedChats: StateFlow<List<Chat>> = _archivedChats

    /**
     * this variable is keeps blocked chats owned by current user for this class
     */
    private val _blockedChats = MutableStateFlow(listOf<Chat>())
    val blockedChats: StateFlow<List<Chat>> = _blockedChats


    init {
        getCurrentUserAndChats()
    }


    /**
     * this method provides to get current user data and also fetch chat
     * rooms of current user.And also edits the list e.g(remove the blocked
     * rooms of users,remove the archived rooms)
     * @sample deleteBlockedRoomsAndMessages
     * @sample addRoomToArchive
     */
    private fun getCurrentUserAndChats() {
        viewModelScope.launch(dispatcher) {
            chatRepository.getChatRoomsOfUser().addSnapshotListener { snapshot, error ->
                if (error != null) {
                    _uiState.value = UiState.Error
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.documents.isNotEmpty()) {
                    val chats = mutableStateListOf<Chat>()
                    for (doc in snapshot.documents) {
                        doc.toObject(Chat::class.java)?.let { chats.add(it) }
                    }
                    getChatRoomsWithMessages(chats)
                    chats.removeAll(deleteBlockedRoomsAndMessages(chats))
                    chats.removeAll(addRoomToArchive(chats))
                    _chats.value = chats
                    _uiState.value = UiState.Success
                }
            }
        }
    }


    fun addRoomToArchive(chat: Chat, value: Boolean) {
        viewModelScope.launch {
            chatRepository.updateTheChatDocumentField(
                chat.chatUid!!,
                FirestoreConstants.CHAT_ROOM_IS_ARCHIVED,
                value
            )
        }
    }


    /**
     * this method provides to adds all blocked members to a list
     * @param blockedRawData is all blocked chat rooms owned by the user
     * @return List<[Chat]> of current user blocked chats
     */
    private fun deleteBlockedRoomsAndMessages(blockedRawData: MutableList<Chat>): List<Chat> {
        val blockedRoomsAndMembers = mutableStateListOf<Chat>()
        for (blockedRoom in blockedRawData) {
            if (blockedRoom.isBlocked) {
                blockedRoomsAndMembers.add(blockedRoom)
            }
        }
        _blockedChats.value = blockedRoomsAndMembers
        return blockedRoomsAndMembers
    }


    /**
     * this method provides to add all archived room owned by the user
     * @param archivedRawData is all archived chat room owned by the user
     * @return List<[Chat]> of current user archived chats
     */
    private fun addRoomToArchive(archivedRawData: List<Chat>): List<Chat> {
        val archivedRooms = mutableStateListOf<Chat>()
        for (archivedRoom in archivedRawData) {
            if (archivedRoom.isArchived) {
                archivedRooms.add(archivedRoom)
            }
        }
        _archivedChats.value = archivedRooms
        return archivedRooms
    }

    /**
     * This method provides to add all room owned by the user but
     * Selects only the chat rooms which have at least 1 message.
     * @param rawData is all chat rooms owned by the user
     * @return List<[Chat]> of current user least a message in a chat room
     */
    private fun getChatRoomsWithMessages(rawData: List<Chat>): List<Chat> {
        val chatsWithMessages = mutableStateListOf<Chat>()
        for (chatRoom in rawData) {
            if (chatRoom.lastMessageDate != null && chatRoom.lastMessageText != null) {
                chatsWithMessages.add(chatRoom)
            }
        }
        return chatsWithMessages
    }
}