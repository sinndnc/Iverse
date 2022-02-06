package com.iverse.core.domain.usecase.storage

import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.domain.model.auth.login.LoginResponseModel

//TODO EDIT THIS CLASS
class SetUserInformationUseCaseImpl constructor(
    private val storageManager: StorageManager
) : SetUserInformationUseCase {

    override suspend fun invoke(model: LoginResponseModel?) {
        storageManager.writeStringData(AuthPreferencesKeys.TOKEN,model!!.token)
        storageManager.writeBooleanData(AuthPreferencesKeys.ISTOKEN,true)
    }
}