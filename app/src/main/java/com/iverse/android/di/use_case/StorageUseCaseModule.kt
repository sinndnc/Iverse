package com.iverse.android.di.use_case

import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.StorageManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class StorageUseCaseModule {

    @Binds
    @Singleton
    abstract fun provideStorageContext(storageManagerImpl: StorageManagerImpl): StorageManager
}