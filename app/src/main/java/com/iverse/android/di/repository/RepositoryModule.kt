package com.iverse.android.di.repository

import com.iverse.core.data.repository.auth.login.LoginRepositoryImpl
import com.iverse.core.data.repository.shuffle.ShuffleRepositoryImpl
import com.iverse.core.domain.repository.auth.login.LoginRepository
import com.iverse.core.domain.repository.message.MessageRepository
import com.iverse.core.domain.repository.message.MessageRepositoryImpl
import com.iverse.core.domain.repository.shuffle.ShuffleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    @Singleton
    abstract fun provideShuffleRepository(shuffleRepositoryImpl: ShuffleRepositoryImpl): ShuffleRepository

    @Binds
    @Singleton
    abstract fun provideMessageRepository(messageRepositoryImpl: MessageRepositoryImpl): MessageRepository

}