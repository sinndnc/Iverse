package com.iverse.feature.presentation.auth.onboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.iverse.core.base.BaseViewModel
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCase
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.utils.connectivity.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor() : BaseViewModel() {

    override val isNetwork: MutableState<NetworkState> = mutableStateOf(NetworkState.CONNECTED)
    override val isLoading: MutableState<Boolean> = mutableStateOf(false)
    override val isPopUp: MutableState<Boolean> = mutableStateOf(false)

}