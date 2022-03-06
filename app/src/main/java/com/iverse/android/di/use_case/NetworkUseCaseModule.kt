package com.iverse.android.di.use_case

import android.content.Context
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.domain.usecase.network.CheckNetworkUseCaseImpl
import com.iverse.core.utils.connectivity.NetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkUseCaseModule {

    @Provides
    @Singleton
    fun provideCheckNetworkUseCase(
        @ApplicationContext context: Context
    ): CheckNetworkUseCase = CheckNetworkUseCaseImpl(NetworkManager(context))

}