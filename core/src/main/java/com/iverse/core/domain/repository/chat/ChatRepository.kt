package com.iverse.core.domain.repository.chat

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface ChatRepository {

  suspend fun getChatRoomsOfUser() : CollectionReference

  suspend fun updateTheChatDocumentField(receiverId: String, field: String, value: Any) : Task<Void>
}