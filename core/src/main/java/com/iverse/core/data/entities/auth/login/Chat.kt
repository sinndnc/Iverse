package com.iverse.core.data.entities.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class Chat(
    val _id: String,
    val messages: List<Message>
)