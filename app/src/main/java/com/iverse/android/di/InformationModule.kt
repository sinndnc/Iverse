package com.iverse.android.di

import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.information.UserInfoService
import com.iverse.core.data.local.storage.information.UserInfoServiceImpl
import com.iverse.core.utils.qualifiers.ID
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class InformationModule {

    @Binds
    @Singleton
    abstract fun bindInformationModule(userInfoServiceImpl: UserInfoServiceImpl): UserInfoService
}


