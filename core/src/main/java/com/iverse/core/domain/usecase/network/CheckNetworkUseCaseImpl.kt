package com.iverse.core.domain.usecase.network

import com.iverse.core.utils.connectivity.NetworkManager
import com.iverse.core.utils.connectivity.NetworkState

//EDIT THIS CLASS
class CheckNetworkUseCaseImpl(
    private val networkManager: NetworkManager
) : CheckNetworkUseCase {

    override fun invoke(): NetworkState =
        if (networkManager.checkInternet == null) NetworkState.UNCONNECTED else NetworkState.CONNECTED

}