package com.iverse.core.base

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.iverse.core.utils.connectivity.NetworkManager
import com.iverse.core.utils.connectivity.NetworkState

abstract class BaseViewModel : ViewModel() {

    abstract val isLoading: MutableState<Boolean>
    abstract val isPopUp: MutableState<Boolean>
    abstract val isNetwork: MutableState<NetworkState>

}