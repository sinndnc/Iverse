package com.iverse.core.domain.model.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class Id(
    val _id: String,
    val name: String,
    val photo: String,
    val username: String
)