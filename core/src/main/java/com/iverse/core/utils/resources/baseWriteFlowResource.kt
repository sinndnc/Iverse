package com.iverse.core.utils.resources

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.iverse.core.data.local.storage.dataStore

suspend fun <T> baseWriteFlowResource(context: Context, key: Preferences.Key<T>, data: T) {
    context.dataStore.edit { preferences ->
        preferences[key] = data
    }
}