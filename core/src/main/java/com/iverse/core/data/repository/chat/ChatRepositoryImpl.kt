package com.iverse.core.data.repository.chat

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.iverse.core.constant.FirestoreConstants
import com.iverse.core.domain.model.ChatType
import com.iverse.core.domain.repository.chat.ChatRepository
import com.iverse.core.utils.qualifiers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val firestore: FirebaseFirestore,
    val firebaseAuth: FirebaseAuth,
) : ChatRepository {

    private val currentUser = firebaseAuth.currentUser!!

    override fun getChatRoomsOfUser(): CollectionReference =
        firestore.collection(FirestoreConstants.USER_COLLECTION)
            .document(currentUser.uid)
            .collection(FirestoreConstants.USER_CHAT_COLLECTION)


    override fun updateTheChatDocumentField(receiverId: String, field: String, value: Any): Task<Void> =
            firestore.collection(FirestoreConstants.USER_COLLECTION)
                .document(currentUser.uid)
                .collection(FirestoreConstants.USER_CHAT_COLLECTION)
                .document(receiverId)
                .update(field, value)



}