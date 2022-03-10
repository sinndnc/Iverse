package com.iverse.core.data.local.storage.information

import androidx.datastore.preferences.core.Preferences

interface UserInfoService {

    suspend fun <T> getUserInformation(key: Preferences.Key<T>): T
}