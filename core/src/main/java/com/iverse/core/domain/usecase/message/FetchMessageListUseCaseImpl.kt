package com.iverse.core.domain.usecase.message

import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.auth.login.Message
import com.iverse.core.domain.model.message.MessageRequestModel
import com.iverse.core.domain.model.shuffle.ShuffleRequestModel
import com.iverse.core.domain.repository.message.MessageRepository
import com.iverse.core.utils.resources.Status

class FetchMessageListUseCaseImpl(
    private val messageRepository: MessageRepository
) : FetchMessageListUseCase {

    override suspend fun invoke(to: String): List<Message> {
        val response = messageRepository.fetchUserMessageList(MessageRequestModel(from = "60bbd972fa019c33c42b2a75", to = to))
        return when (response.status) {
            Status.SUCCESS -> response.data!!
            Status.ERROR -> emptyList()
            else -> {
                emptyList()
            }
        }
    }

}