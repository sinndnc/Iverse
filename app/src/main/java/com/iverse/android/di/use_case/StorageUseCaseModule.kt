package com.iverse.android.di.use_case

import android.content.Context
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.StorageManagerImpl
import com.iverse.core.domain.usecase.storage.SetUserInformationUseCase
import com.iverse.core.domain.usecase.storage.SetUserInformationUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class StorageUseCaseModule {

    @Binds
    @Singleton
    abstract fun provideSetUserInformationUseCase(
        setUserInformationUseCaseImpl: SetUserInformationUseCaseImpl
    ): SetUserInformationUseCase

}