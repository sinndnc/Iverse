package com.iverse.feature.presentation.main.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iverse.core.utils.theme.AppTheme
import com.iverse.core.utils.theme.ThemeSetting
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val themeSetting: ThemeSetting) : ViewModel() {

    fun changeToDarkTheme() {
        themeSetting.changeToTheme(AppTheme.DARK)
    }

    fun changeToLightTheme() {
        themeSetting.changeToTheme(AppTheme.LIGHT)
    }

}