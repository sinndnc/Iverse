package com.iverse.core.domain.model

import java.util.*


data class Message(

    var message : String = "",

    @field:JvmField
    var isDeleted : Boolean = false,

    var time : Date? = null,

    var senderId : String = ""
)
