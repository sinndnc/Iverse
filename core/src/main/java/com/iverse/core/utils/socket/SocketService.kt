package com.iverse.core.utils.socket

import io.socket.client.Socket

abstract class SocketService {

    abstract operator fun invoke(): Socket

    abstract fun attemptToChat(id: String)

    abstract fun receiveMessage()

    abstract fun sendMessage(senderId: String, message: String, receiverId: String)

    abstract fun destroy(): Socket
}