package com.iverse.core.domain.usecase.message

import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.auth.login.Message

interface FetchMessageListUseCase {

    suspend operator fun invoke(to : String) : List<Message>
}