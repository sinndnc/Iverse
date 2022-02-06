package com.iverse.core.domain.repository.auth.login

import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.model.auth.login.LoginResponseModel
import com.iverse.core.utils.resources.Resource

interface LoginRepository {

    suspend fun loginToAccount(model: LoginRequestModel?): Resource<LoginResponseModel?>
}