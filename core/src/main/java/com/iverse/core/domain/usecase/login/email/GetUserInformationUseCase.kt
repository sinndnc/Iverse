package com.iverse.core.domain.usecase.login.email

import com.iverse.core.base.Resource
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.model.auth.login.LoginResponseModel


interface GetUserInformationUseCase {

    suspend operator fun invoke(model: LoginRequestModel?): Resource<LoginResponseModel?>

}