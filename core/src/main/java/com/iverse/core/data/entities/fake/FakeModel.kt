package com.iverse.core.data.entities.fake

import kotlinx.serialization.Serializable

@Serializable
data class FakeModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)