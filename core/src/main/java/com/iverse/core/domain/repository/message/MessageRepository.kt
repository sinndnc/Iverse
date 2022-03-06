package com.iverse.core.domain.repository.message

import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.auth.login.Message
import com.iverse.core.domain.model.message.MessageRequestModel
import com.iverse.core.utils.resources.Resource

interface MessageRepository {

    suspend fun fetchUserMessageList(id: MessageRequestModel): Resource<List<Message>>

}