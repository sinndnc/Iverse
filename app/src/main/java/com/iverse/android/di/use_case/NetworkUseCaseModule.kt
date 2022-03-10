package com.iverse.android.di.use_case

import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.domain.usecase.network.CheckNetworkUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkUseCaseModule {

    @Binds
    @Singleton
    abstract fun provideCheckNetworkUseCase(
        checkNetworkUseCaseImpl: CheckNetworkUseCaseImpl
    ): CheckNetworkUseCase

}