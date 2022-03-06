package com.iverse.core.utils.theme

import kotlinx.coroutines.flow.StateFlow


enum class AppTheme {
    DEFAULT,
    LIGHT,
    DARK;

    companion object {
        fun fromOrdinal(ordinal: Int) = values()[ordinal]
    }
}

interface ThemeSetting {
    val themeStream: StateFlow<AppTheme>
    val ordinalTheme : Int
    val theme: AppTheme

    fun changeToTheme(newTheme: AppTheme)
}
