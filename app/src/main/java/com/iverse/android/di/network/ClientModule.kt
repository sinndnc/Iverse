package com.iverse.android.di.network

import com.iverse.core.domain.repository.auth.login.LoginRepository
import com.iverse.core.data.repository.auth.login.LoginRepositoryImpl
import com.iverse.core.data.repository.shuffle.ShuffleRepositoryImpl
import com.iverse.core.domain.repository.message.MessageRepository
import com.iverse.core.domain.repository.message.MessageRepositoryImpl
import com.iverse.core.domain.repository.shuffle.ShuffleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.websocket.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {

    @Provides
    @Singleton
    fun provideNetworkService(): HttpClient = HttpClient(CIO) {
        install(WebSockets)
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json { ignoreUnknownKeys = true })

        }
    }

    @Provides
    @Singleton
    fun provideLoginRepository(client: HttpClient): LoginRepository =
        LoginRepositoryImpl(client = client)

    @Provides
    @Singleton
    fun provideShuffleRepository(client: HttpClient): ShuffleRepository = ShuffleRepositoryImpl(client = client)

    @Provides
    @Singleton
    fun provideMessageRepository(client: HttpClient): MessageRepository = MessageRepositoryImpl(client = client)


}