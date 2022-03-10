package com.iverse.core.domain.usecase.storage

import com.iverse.core.domain.model.auth.login.LoginResponseModel

interface SetUserInformationUseCase {

    suspend fun setData(model: LoginResponseModel?)
}