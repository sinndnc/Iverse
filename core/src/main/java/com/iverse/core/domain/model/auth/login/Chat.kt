package com.iverse.core.domain.model.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class Chat(
    val _id: Id,
    val messages: List<Message>
)