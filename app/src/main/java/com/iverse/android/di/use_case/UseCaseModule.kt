package com.iverse.android.di.use_case

import android.content.Context
import com.iverse.core.domain.repository.auth.login.LoginRepository
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCase
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCaseImpl
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.domain.usecase.network.CheckNetworkUseCaseImpl
import com.iverse.core.domain.usecase.storage.SetUserInformationUseCase
import com.iverse.core.domain.usecase.storage.SetUserInformationUseCaseImpl
import com.iverse.core.utils.connectivity.NetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideSetUserInformationUseCase(): SetUserInformationUseCase =
        SetUserInformationUseCaseImpl()


    @Provides
    @Singleton
    fun provideGetUserInformationUseCase(
        setUserInformationUseCase: SetUserInformationUseCase,
        loginRepository: LoginRepository
    ): GetUserInformationUseCase =
        GetUserInformationUseCaseImpl(setUserInformationUseCase, loginRepository)


    @Provides
    @Singleton
    fun provideCheckNetworkUseCase(@ApplicationContext context: Context): CheckNetworkUseCase =
        CheckNetworkUseCaseImpl(NetworkManager(context))
}