package com.iverse.core.domain.model

import androidx.annotation.Keep
import com.google.firebase.firestore.PropertyName
import com.iverse.core.constant.FirestoreConstants
import java.util.*


enum class ChatType { Private, Group }


data class Chat(

    @PropertyName(FirestoreConstants.CHAT_ROOM_RECEIVER_UID)
    var chatUid: String? = null,

    @PropertyName(FirestoreConstants.CHAT_ROOM_TYPE)
    var chatType: String? = null,

    @PropertyName(FirestoreConstants.CHAT_ROOM_NAME)
    var chatName: String = "",

    @PropertyName(FirestoreConstants.CHAT_ROOM_IMAGE)
    var chatImage: String = "",

    @PropertyName(FirestoreConstants.CHAT_ROOM_IS_BLOCKED)
    @field:JvmField
    var isBlocked: Boolean = false,

    @PropertyName(FirestoreConstants.CHAT_ROOM_IS_ARCHIVED)
    @field:JvmField
    var isArchived: Boolean = false,

    @PropertyName(FirestoreConstants.CHAT_ROOM_LAST_MESSAGE_TEXT)
    var lastMessageText: String? = null,

    @PropertyName(FirestoreConstants.CHAT_ROOM_LAST_MESSAGE_DATE)
    var lastMessageDate: Date? = null,

    @PropertyName(FirestoreConstants.CHAT_ROOM_MEMBERS)
    var members: List<String>? = null,

    //TODO
    @PropertyName(FirestoreConstants.CHAT_ROOM_MESSAGES)
    var messages: List<Message>? = null

)

