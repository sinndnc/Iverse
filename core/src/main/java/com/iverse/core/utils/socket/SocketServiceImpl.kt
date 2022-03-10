package com.iverse.core.utils.socket


import android.util.Log
import com.iverse.core.domain.model.auth.login.Message
import io.socket.client.Socket
import org.json.JSONObject
import javax.inject.Inject

class SocketServiceImpl @Inject constructor(
    private val socket: Socket,
) : SocketService() {

    override operator fun invoke(): Socket = socket.connect()

    override fun attemptToChat(id: String) {
        val map = mapOf("id" to id)
        socket.emit("entered_chat", JSONObject(map))
    }

    override fun receiveMessage() {
        Log.d("SocketTest", "buraya girdi")
        socket.on("received_message") { Chat ->
            Log.d("SocketTest", "buraya girdiiii")
            Log.d("SocketTest", Chat[0].toString())
        }
    }

    override fun sendMessage(senderId: String, message: String ,receiverId: String) {
        val map = mapOf(
            "receiverId" to receiverId,
            "senderId" to senderId,
            "message" to message,
        )
        socket.emit("send_message", JSONObject(map))
    }


    override fun destroy(): Socket = socket.disconnect()
}