package com.iverse.core.domain.model.auth.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(
    val email: String,
    val password: String,
)