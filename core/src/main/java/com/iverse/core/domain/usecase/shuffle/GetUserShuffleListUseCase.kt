package com.iverse.core.domain.usecase.shuffle

import com.iverse.core.domain.model.auth.login.Chat


interface GetUserShuffleListUseCase {

    suspend operator fun invoke() : List<Chat>

}