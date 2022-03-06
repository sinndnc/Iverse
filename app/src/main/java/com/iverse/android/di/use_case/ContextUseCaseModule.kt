package com.iverse.android.di.use_case

import android.content.Context
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.StorageManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContextUseCaseModule {

    @Provides
    @Singleton
    fun provideStorageContext(@ApplicationContext context: Context):
            StorageManager = StorageManagerImpl(context)
}