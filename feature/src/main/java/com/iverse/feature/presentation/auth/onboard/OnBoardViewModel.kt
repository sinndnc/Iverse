package com.iverse.feature.presentation.auth.onboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.iverse.core.base.BaseViewModel
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.utils.connectivity.NetworkState

class OnBoardViewModel(
    checkNetworkUseCase: CheckNetworkUseCase
) : BaseViewModel() {

    override val isNetwork: MutableState<NetworkState> = checkNetworkUseCase.isNetwork
    override val isLoading: MutableState<Boolean> = mutableStateOf(false)
    override val isPopUp: MutableState<Boolean> = mutableStateOf(false)

}