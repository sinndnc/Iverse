package com.iverse.core.data.repository.chatRoom

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.iverse.core.constant.FirestoreConstants
import com.iverse.core.domain.repository.chatRoom.ChatRoomRepository
import com.iverse.core.utils.qualifiers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val firestore: FirebaseFirestore,
) : ChatRoomRepository {

    //TODO
    override suspend fun getChatRooms(userUid: String, chatUserUid: String): Task<DocumentSnapshot> =
        withContext(dispatcher) {
            firestore.collection(FirestoreConstants.USER_COLLECTION)
                .document(userUid)
                .collection(FirestoreConstants.USER_CHAT_COLLECTION)
                .document(chatUserUid)
                .get()
        }


}