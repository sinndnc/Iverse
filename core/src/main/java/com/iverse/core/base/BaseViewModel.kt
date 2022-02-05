package com.iverse.core.base

import com.iverse.core.utils.connectivity.NetworkState

interface BaseViewModel {

    var isLoading: Boolean
    var isPopUp: Boolean
    var isNetwork: NetworkState

}