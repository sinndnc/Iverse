package com.iverse.core.domain.usecase.login.email

import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.model.auth.login.LoginResponseModel
import com.iverse.core.utils.resources.Resource


interface GetUserInformationUseCase {

    suspend  fun invoke(model: LoginRequestModel?): Resource<LoginResponseModel?>

}