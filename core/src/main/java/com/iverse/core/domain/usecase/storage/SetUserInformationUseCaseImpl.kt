package com.iverse.core.domain.usecase.storage

import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.domain.model.auth.login.LoginResponseModel
import javax.inject.Inject

//TODO EDIT THIS CLASS
class SetUserInformationUseCaseImpl @Inject constructor(
    private val storageManager: StorageManager
) : SetUserInformationUseCase {

    override suspend fun setData(model: LoginResponseModel?) {
        if (model != null) {
            storageManager.writeStringData(AuthPreferencesKeys.TOKEN, model.token)
            storageManager.writeStringData(AuthPreferencesKeys.ID, model._id)
        }
    }
}