package com.iverse.core.domain.usecase.firebase

import com.google.android.gms.tasks.Task
import com.iverse.core.domain.repository.chat.ChatRepository
import javax.inject.Inject


class UpdateDocumentImpl @Inject constructor(
    private val chatRepository: ChatRepository
) : UpdateDocument {

    override suspend fun updateChatDocument(receiverId: String, field: String, value: Any): Task<Void> =
        chatRepository.updateTheChatDocumentField(receiverId, field, value).addOnCompleteListener { result ->
            if (result.isSuccessful) {
                result.result.toString()
            } else {
                result.exception.toString()
            }
        }

}