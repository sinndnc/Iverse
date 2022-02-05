package com.iverse.core.domain.usecase.network

import com.iverse.core.utils.connectivity.NetworkState

interface CheckNetworkUseCase {

    operator fun invoke() : NetworkState
}