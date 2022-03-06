package com.iverse.core.domain.usecase.shuffle

import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.domain.model.auth.login.Chat
import com.iverse.core.domain.model.shuffle.ShuffleRequestModel
import com.iverse.core.domain.repository.shuffle.ShuffleRepository
import com.iverse.core.utils.resources.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext


class GetUserShuffleListUseCaseImpl(
    private val shuffleRepository: ShuffleRepository,
    private val storageManager: StorageManager,
) : GetUserShuffleListUseCase {

    override suspend fun invoke(): List<Chat> {
        val id = withContext(Dispatchers.IO) { storageManager.readStringData(AuthPreferencesKeys.ID).first() ?: "" }
        val response = shuffleRepository.fetchUserShuffleList(ShuffleRequestModel("60bbd972fa019c33c42b2a75"))
        return when (response.status) {
            Status.SUCCESS -> response.data!!
            Status.ERROR -> emptyList()
            else -> {
                emptyList()
            }
        }
    }

}