package com.iverse.core.domain.repository.chatRoom

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.iverse.core.domain.model.Message

interface ChatRoomRepository {

     fun getChatRooms(chatUserUid: String): DocumentReference

     fun sendMessageToChatRoom(chatRoomUid: String, message: Message): Task<Void>

}