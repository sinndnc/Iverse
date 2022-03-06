package com.iverse.android.di.use_case

import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.domain.repository.message.MessageRepository
import com.iverse.core.domain.repository.shuffle.ShuffleRepository
import com.iverse.core.domain.usecase.message.FetchMessageListUseCase
import com.iverse.core.domain.usecase.message.FetchMessageListUseCaseImpl
import com.iverse.core.domain.usecase.shuffle.GetUserShuffleListUseCase
import com.iverse.core.domain.usecase.shuffle.GetUserShuffleListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MessageUseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserShuffleListUseCase(
        shuffleRepository: ShuffleRepository,
        storageManager: StorageManager
    ): GetUserShuffleListUseCase = GetUserShuffleListUseCaseImpl(shuffleRepository, storageManager)

    @Provides
    @Singleton
    fun provideGetUserMessageListUseCase(
        messageRepository: MessageRepository
    ): FetchMessageListUseCase = FetchMessageListUseCaseImpl(messageRepository)


}