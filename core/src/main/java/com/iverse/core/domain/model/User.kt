package com.iverse.core.domain.model

import com.google.firebase.firestore.PropertyName
import com.iverse.core.constant.FirestoreConstants

data class User(

    @PropertyName(FirestoreConstants.USER_UID)
    var uid: String = "",


    @PropertyName(FirestoreConstants.USER_DISPLAY_NAME)
    var displayName: String = "",

    /*
    /**
     * Friends ([User] uid-s) of this user.
     */
    @PropertyName(FirestoreConstants.USER_FRIENDS)
    var friends: List<String> = listOf(),

    /**
     * [User] uid-s of those users who have been blocked by this user.
     */
    @PropertyName(FirestoreConstants.USER_BLOCKS)
    var blockedUsers: List<String> = listOf(),

    /**
     * FCM message token of this user. Used to target the user (their device) with FCM messages.
     */
    @PropertyName(FirestoreConstants.USER_MESSAGE_TOKEN)
    var messageToken: String = ""

     */
)