package com.iverse.core.domain.usecase.firebase

import com.google.android.gms.tasks.Task

interface UpdateDocument {

    suspend fun updateChatDocument(receiverId: String, field: String, value: Any): Task<Void>

}
