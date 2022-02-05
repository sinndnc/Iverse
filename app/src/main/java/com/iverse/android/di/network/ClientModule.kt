package com.iverse.android.di.network

import com.iverse.core.domain.repository.auth.login.LoginRepository
import com.iverse.core.data.repository.auth.login.LoginRepositoryImpl
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
            serializer = KotlinxSerializer()
        }
    }

    @Provides
    @Singleton
    fun provideLoginRepository(client: HttpClient): LoginRepository =
        LoginRepositoryImpl(client = client)


}