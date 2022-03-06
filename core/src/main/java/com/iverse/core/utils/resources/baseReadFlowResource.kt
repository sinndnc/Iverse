package com.iverse.core.utils.resources

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.*
import java.io.IOException


fun <T> Flow<Preferences>.baseReadFlowResource(key: Preferences.Key<T>): Flow<T?> =
    catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        preferences[key]
    }
