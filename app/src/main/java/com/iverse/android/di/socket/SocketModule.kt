package com.iverse.android.di.socket

import android.util.Log
import com.iverse.core.utils.socket.SocketService
import com.iverse.core.utils.socket.SocketServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SocketModule {

    @Binds
    @Singleton
    abstract fun bindSocketService(socketServiceImpl: SocketServiceImpl): SocketService
}

@Module
@InstallIn(SingletonComponent::class)
object SocketProvideModule {

    @Provides
    @Singleton
    fun provideSocketService(): Socket = IO.socket("http://192.168.2.247:4001")


}