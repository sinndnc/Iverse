package com.iverse.core.data.local.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow


//TODO if I wanna add to any type of save data on local storage add it in here
abstract class StorageManager {
    abstract val dataStore: DataStore<Preferences>

    //String
    abstract suspend fun writeStringData(key: Preferences.Key<String>, data: String)
    abstract suspend fun readStringData(key: Preferences.Key<String>): String?

    //Int
    abstract suspend fun writeIntData(key: Preferences.Key<Int>, data: Int)
    abstract suspend fun readIntData(key: Preferences.Key<Int>): Int?

    //Boolean
    abstract suspend fun writeBooleanData(key: Preferences.Key<Boolean>, data: Boolean)
    abstract suspend fun readBooleanData(key: Preferences.Key<Boolean>): Boolean?


}