package com.iverse.core.domain.usecase.network

import androidx.compose.runtime.MutableState
import com.iverse.core.utils.connectivity.NetworkState

interface CheckNetworkUseCase {

    val isNetwork : MutableState<NetworkState>
}