package com.iverse.android.di.use_case


import com.iverse.core.domain.repository.auth.login.LoginRepository
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCase
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCaseImpl
import com.iverse.core.domain.usecase.storage.SetUserInformationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginUseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserInformationUseCase(
        setUserInformationUseCase: SetUserInformationUseCase,
        loginRepository: LoginRepository
    ): GetUserInformationUseCase =
        GetUserInformationUseCaseImpl(setUserInformationUseCase, loginRepository)
}