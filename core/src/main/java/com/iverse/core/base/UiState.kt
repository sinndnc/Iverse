package com.iverse.core.base


sealed class UiState {
    object Success : UiState()
    object Loading : UiState()
    object Error : UiState()
    object Processing : UiState()
}
