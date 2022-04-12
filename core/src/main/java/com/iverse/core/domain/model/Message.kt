package com.iverse.core.domain.model

import java.util.*


data class Message(

    var message: String = "",

    var senderId: String? = null,

    @field:JvmField
    var isDeleted: Boolean = false,

    var date: Date? = null,

)
