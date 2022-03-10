package com.iverse.android.di.use_case

import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.domain.repository.message.MessageRepository
import com.iverse.core.domain.repository.shuffle.ShuffleRepository
import com.iverse.core.domain.usecase.message.FetchMessageListUseCase
import com.iverse.core.domain.usecase.message.FetchMessageListUseCaseImpl
import com.iverse.core.domain.usecase.shuffle.GetUserShuffleListUseCase
import com.iverse.core.domain.usecase.shuffle.GetUserShuffleListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class MessageUseCaseModule {

    @Binds
    @Singleton
    abstract fun provideGetUserShuffleListUseCase(
        getUserShuffleListUseCaseImpl: GetUserShuffleListUseCaseImpl
    ): GetUserShuffleListUseCase

    @Binds
    @Singleton
    abstract fun provideGetUserMessageListUseCase(
        fetchMessageListUseCaseImpl: FetchMessageListUseCaseImpl
    ): FetchMessageListUseCase


}