package com.iverse.feature.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.iverse.core.base.BaseViewModel
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.utils.connectivity.NetworkManager
import com.iverse.core.utils.connectivity.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    checkNetworkUseCase: CheckNetworkUseCase
) : BaseViewModel() {

    override val isNetwork: MutableState<NetworkState> = checkNetworkUseCase.isNetwork
    override val isLoading: MutableState<Boolean> = mutableStateOf(false)
    override val isPopUp: MutableState<Boolean> = mutableStateOf(false)


}
