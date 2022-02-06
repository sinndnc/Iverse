package com.iverse.core.constant

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object AuthPreferencesKeys {
    val NAME = stringPreferencesKey("name")
    val SURNAME = stringPreferencesKey("surname")
    val MAIL = stringPreferencesKey("mail")
    val PASSWORD = stringPreferencesKey("password")
    val PHOTO = stringPreferencesKey("photo")
    val TOKEN = stringPreferencesKey("token")
    val ISTOKEN = booleanPreferencesKey("isToken")
}