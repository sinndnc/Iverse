package com.iverse.core.domain.repository.auth.login

import com.iverse.core.base.Resource
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.model.auth.login.LoginResponseModel

interface LoginRepository {

    suspend fun loginToAccount(model: LoginRequestModel?): Resource<LoginResponseModel?>
}