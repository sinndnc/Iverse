package com.iverse.core.domain.usecase.login.email

import android.util.Log
import com.iverse.core.base.Resource
import com.iverse.core.base.Status
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.model.auth.login.LoginResponseModel
import com.iverse.core.domain.repository.auth.login.LoginRepository
import com.iverse.core.domain.usecase.storage.SetUserInformationUseCase
import javax.inject.Inject

class GetUserInformationUseCaseImpl @Inject constructor(
    private val setUserInformationUseCase: SetUserInformationUseCase,
    private val loginRepository: LoginRepository,
) : GetUserInformationUseCase {

    override suspend fun invoke(model: LoginRequestModel?): Resource<LoginResponseModel?> {
        val result = loginRepository.loginToAccount(model)
        return when (result.status) {
            Status.SUCCESS -> {
                Log.d("UseCaseTestResult",result.data.toString())
                setUserInformationUseCase.invoke(result.data)
                Resource.success(result.data)
            }
            Status.LOADING -> {Resource.loading()}
            else -> {Resource.error(result.message.toString())}
        }
    }
}