package com.iverse.core.utils.resources

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.iverse.core.data.local.storage.dataStore

suspend fun <T> Context.baseWriteFlowResource(key: Preferences.Key<T>, data: T) {
    dataStore.edit { preferences ->
        preferences[key] = data
    }
}