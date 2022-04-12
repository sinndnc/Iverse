package com.iverse.android.di.setting

import com.iverse.core.utils.notification.NotificationComponent
import com.iverse.core.utils.notification.NotificationComponentImpl
import com.iverse.core.utils.notification.NotificationHelper
import com.iverse.core.utils.notification.NotificationHelperImpl
import com.iverse.core.utils.theme.ThemeSetting
import com.iverse.core.utils.theme.ThemeSettingImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    @Singleton
    abstract fun bindNotificationModule(notificationHelperImpl: NotificationHelperImpl): NotificationHelper

    @Binds
    @Singleton
    abstract fun bindNotificationComponent(notificationComponentImpl: NotificationComponentImpl): NotificationComponent

    @Binds
    @Singleton
    abstract fun bindThemeSetting(themeSettingPreference: ThemeSettingImpl): ThemeSetting
}
