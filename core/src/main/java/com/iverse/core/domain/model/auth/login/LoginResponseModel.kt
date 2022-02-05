package com.iverse.core.domain.model.auth.login

import kotlinx.serialization.Serializable


@Serializable
data class LoginResponseModel(
    val __v: Int,
    val _id: String,
    val chats: List<Chat>,
    val email: String,
    val friends: List<String>,
    val isAdmin: Boolean,
    val isEmailVerified: Boolean,
    val language: String,
    val name: String,
    val password: String,
    val photo: String,
    val platforms: List<String>,
    val region: String,
    val sex: String,
    val surname: String,
    val token: String,
    val username: String
)