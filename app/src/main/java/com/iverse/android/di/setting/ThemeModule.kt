package com.iverse.android.di.setting

import com.iverse.core.utils.theme.ThemeSetting
import com.iverse.core.utils.theme.ThemeSettingImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ThemeModule {

    @Binds
    @Singleton
    abstract fun bindThemeSetting(themeSettingPreference: ThemeSettingImpl): ThemeSetting
}