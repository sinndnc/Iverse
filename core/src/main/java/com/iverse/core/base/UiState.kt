package com.iverse.core.base


sealed class UiState {
    data class Success<T>(val data: T) : UiState()
    object Loading : UiState()
    object Error : UiState()
    object Processing : UiState()
}
