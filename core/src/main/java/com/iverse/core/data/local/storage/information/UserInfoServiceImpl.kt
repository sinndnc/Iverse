package com.iverse.core.data.local.storage.information

import androidx.datastore.preferences.core.Preferences
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.utils.qualifiers.IoDispatcher
import com.iverse.core.utils.resources.baseReadFlowResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserInfoServiceImpl @Inject constructor(
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val storageManager: StorageManager
) : UserInfoService {

    override suspend fun <T> getUserInformation(key: Preferences.Key<T>): T =
        withContext(coroutineDispatcher) { storageManager.dataStore.baseReadFlowResource(key).first() }
}