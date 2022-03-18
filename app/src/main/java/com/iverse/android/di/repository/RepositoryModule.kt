package com.iverse.android.di.repository

import com.iverse.core.data.repository.user.UserRepositoryImpl
import com.iverse.core.data.repository.chat.ChatRepositoryImpl
import com.iverse.core.data.repository.chatRoom.ChatRoomRepositoryImpl
import com.iverse.core.domain.repository.user.UserRepository
import com.iverse.core.domain.repository.chat.ChatRepository
import com.iverse.core.domain.repository.chatRoom.ChatRoomRepository
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
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl) : UserRepository

    @Binds
    @Singleton
    abstract fun bindChatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository


    @Binds
    @Singleton
    abstract fun bindChatRoomRepository(chatRoomRepositoryImpl: ChatRoomRepositoryImpl): ChatRoomRepository

    /*
    @Binds
    @Singleton
    abstract fun bindMessageRepository(messageRepositoryImpl: MessageRepositoryImpl): MessageRepository
     */


}