package com.iverse.core.data.local.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.iverse.core.constant.AppConstant
import com.iverse.core.utils.resources.baseReadFlowResource
import com.iverse.core.utils.resources.baseWriteFlowResource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = AppConstant.LOCAL_STORAGE_NAME)

class StorageManagerImpl @Inject constructor(@ApplicationContext private val context: Context) : StorageManager() {

    override val dataStore: DataStore<Preferences> get() = context.dataStore

    override suspend fun writeStringData(key: Preferences.Key<String>, data: String) =
        withContext(Dispatchers.IO) { baseWriteFlowResource(context, key, data) }

    override suspend fun readStringData(key: Preferences.Key<String>): String? =
        withContext(Dispatchers.IO) { baseReadFlowResource(dataStore.data, key) }

    override suspend fun writeIntData(key: Preferences.Key<Int>, data: Int) =
        withContext(Dispatchers.IO) { baseWriteFlowResource(context, key, data) }

    override suspend fun readIntData(key: Preferences.Key<Int>): Int? =
        withContext(Dispatchers.IO) { baseReadFlowResource(dataStore.data, key) }

    override suspend fun writeBooleanData(key: Preferences.Key<Boolean>, data: Boolean) =
        withContext(Dispatchers.IO) { baseWriteFlowResource(context, key, data) }

    override suspend fun readBooleanData(key: Preferences.Key<Boolean>): Boolean? =
        withContext(Dispatchers.IO) { baseReadFlowResource(dataStore.data, key) }

}