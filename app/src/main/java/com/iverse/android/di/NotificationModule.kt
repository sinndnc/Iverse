package com.iverse.android.di

import android.content.Context
import android.content.Intent
import com.iverse.android.MainActivity
import com.iverse.core.utils.qualifiers.NOTIFICATION
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    @Singleton
    @NOTIFICATION
    fun provideNotification(@ApplicationContext context : Context) : Intent =
        Intent(context, MainActivity::class.java)

}