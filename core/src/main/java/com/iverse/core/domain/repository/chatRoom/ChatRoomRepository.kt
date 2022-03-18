package com.iverse.core.domain.repository.chatRoom

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot

interface ChatRoomRepository {

    suspend fun getChatRooms(userUid : String, chatUserUid : String) : Task<DocumentSnapshot>

}