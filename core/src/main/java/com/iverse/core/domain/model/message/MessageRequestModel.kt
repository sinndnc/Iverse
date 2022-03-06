package com.iverse.core.domain.model.message

import kotlinx.serialization.Serializable

@Serializable
data class MessageRequestModel(
    val from: String,
    val to: String
)
