package com.iverse.core.domain.model.auth.login

import kotlinx.serialization.Serializable


@Serializable
data class Message(
    val _id: String,
    val date: String,
    val isMy: Boolean,
    val message: String
)