package com.iverse.core.data.entities.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(
    val email: String,
    val password: String,
)