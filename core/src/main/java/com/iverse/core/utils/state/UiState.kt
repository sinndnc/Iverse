package com.iverse.core.utils.state


sealed class UiState {
    object Success : UiState()
    object Loading : UiState()
    object Error : UiState()
    object OnProgress : UiState()
}
