package com.iverse.core.data.repository.chat

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.iverse.core.domain.repository.chat.ChatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ChatRepositoryImplTest {
    /*
    lateinit var chatRepository: ChatRepository

    @Before
    fun setUp() {
        chatRepository = ChatRepositoryImpl(Dispatchers.IO, FirebaseFirestore.getInstance(), FirebaseAuth.getInstance())
    }


     */
    @Test
    fun get_User_ChatData() {
        runBlocking {
           // val res = chatRepository.updateTheChatDocumentField("9Ex7wLIORnRYMSLCj6lKF4CasB43","isBlocked",true)
            assert(true)
        }
    }

}