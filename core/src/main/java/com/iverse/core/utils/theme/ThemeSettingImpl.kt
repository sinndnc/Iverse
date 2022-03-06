package com.iverse.core.utils.theme

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ThemeSettingImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ThemeSetting {

    override val themeStream: MutableStateFlow<AppTheme>
    override val ordinalTheme = runBlocking {
        context.dataStore.data.map { preference -> preference[AuthPreferencesKeys.THEME] ?: 0 }.first()
    }
    override val theme: AppTheme = AppTheme.fromOrdinal(ordinalTheme)

    init {
        themeStream = MutableStateFlow(theme)
    }

    override fun changeToTheme(newTheme: AppTheme) {
        themeStream.value = newTheme
        runBlocking {
            context.dataStore.edit {
                it[AuthPreferencesKeys.THEME] = newTheme.ordinal
            }
        }
    }
}

