package com.iverse.android.di.use_case


import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCase
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginUseCaseModule {

    @Binds
    @Singleton
    abstract fun provideGetUserInformationUseCase(
        getUserInformationUseCaseImpl: GetUserInformationUseCaseImpl
    ): GetUserInformationUseCase
}