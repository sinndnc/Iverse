package com.iverse.core.domain.repository.shuffle

import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.shuffle.ShuffleRequestModel
import com.iverse.core.utils.resources.Resource

interface ShuffleRepository {

    suspend fun fetchUserShuffleList(id: ShuffleRequestModel): Resource<List<Chat>>
}