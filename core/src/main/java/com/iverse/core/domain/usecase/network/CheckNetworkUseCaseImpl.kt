package com.iverse.core.domain.usecase.network

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.iverse.core.utils.connectivity.NetworkManager
import com.iverse.core.utils.connectivity.NetworkState
import javax.inject.Inject

class CheckNetworkUseCaseImpl (
    networkManager: NetworkManager
) : CheckNetworkUseCase {

    private val networkResult: NetworkState =
        if (networkManager.checkInternet == null) NetworkState.UNCONNECTED else NetworkState.CONNECTED
    override val isNetwork: MutableState<NetworkState> = mutableStateOf(networkResult)

    init {
        networkManager.observeForever {
            isNetwork.value = it
            Log.d("NetworkResultValue", isNetwork.value.toString())
        }
    }

}