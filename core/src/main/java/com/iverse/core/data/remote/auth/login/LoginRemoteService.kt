package com.iverse.core.data.remote.auth.login

import com.iverse.core.base.Resource
import com.iverse.core.data.entities.auth.login.LoginRequestModel
import com.iverse.core.data.entities.auth.login.LoginResponseModel
import com.iverse.core.data.entities.fake.FakeModel

interface LoginRemoteService {

    suspend fun loginToAccount(model: LoginRequestModel): Resource<LoginResponseModel?>
}