package com.iverse.feature.presentation.auth.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.iverse.core.base.BaseViewModel
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCase
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.core.utils.resources.Status
import com.iverse.feature.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO EDIT THIS CLASS
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserInformationUseCase: GetUserInformationUseCase,
    checkNetworkUseCase: CheckNetworkUseCase,
) : BaseViewModel() {

    override val isNetwork: MutableState<NetworkState> = checkNetworkUseCase.isNetwork
    override val isLoading: MutableState<Boolean> = mutableStateOf(false)
    override val isPopUp: MutableState<Boolean> = mutableStateOf(false)


    //TODO ADD STORAGE MANAGER FOR SAVE TOKEN AND etc.
    fun signInWithEmail(loginRequestModel: LoginRequestModel, navController: NavController) {
        isLoading.value = true
        viewModelScope.launch {
            val response = getUserInformationUseCase.invoke(loginRequestModel)
            when (response.status) {
                Status.ERROR -> {
                    //TODO SHOW POP UP TO FOR WRONG LOGIN INFO
                    isLoading.value = false
                }
                Status.SUCCESS -> {
                    isLoading.value = false
                    navController.navigate(route = Screens.HomeUI.route) {
                        popUpTo(Screens.LoginUI.route) { inclusive = true }
                    }
                }
                else -> isLoading.value = false
            }
        }
    }

    /*
    fun signInWithGoogle(launcher: ManagedActivityResultLauncher<Intent, ActivityResult>) {
        isLoading.value = true
        launcher.launch(googleClient.signInIntent)
        isLoading.value = false
    }
    */

    fun signInWithGithub() {}

}
