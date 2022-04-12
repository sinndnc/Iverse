package com.iverse.core.data.repository.chatRoom

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.iverse.core.constant.FirestoreConstants
import com.iverse.core.domain.model.Message
import com.iverse.core.domain.repository.chatRoom.ChatRoomRepository
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    firebaseAuth: FirebaseAuth,
) : ChatRoomRepository {

    private val currentUserUid = firebaseAuth.currentUser!!.uid

    override  fun getChatRooms(chatUserUid: String): DocumentReference =
            firestore.collection(FirestoreConstants.USER_COLLECTION)
                .document(currentUserUid)
                .collection(FirestoreConstants.USER_CHAT_COLLECTION)
                .document(chatUserUid)


    //TODO
    override  fun sendMessageToChatRoom(chatRoomUid: String, message: Message) =
            firestore.collection(FirestoreConstants.USER_COLLECTION)
                .document(currentUserUid)
                .collection(FirestoreConstants.USER_CHAT_COLLECTION)
                .document(chatRoomUid)
                .update("messages", FieldValue.arrayUnion(message))



}