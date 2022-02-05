package com.iverse.feature.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iverse.core.base.BaseViewModel
import com.iverse.core.domain.model.auth.login.LoginRequestModel
import com.iverse.core.domain.usecase.login.email.GetUserInformationUseCase
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.utils.connectivity.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//EDIT THIS CLASS
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserInformationUseCase: GetUserInformationUseCase,
    private val checkNetworkUseCase: CheckNetworkUseCase,
) : BaseViewModel, ViewModel() {


    private val networkResult = checkNetworkUseCase.invoke()
    override var isNetwork: NetworkState = networkResult
    override var isLoading: Boolean = false
    override var isPopUp: Boolean = false

    fun loginWithUseCase(model: LoginRequestModel?) {
        viewModelScope.launch {
            getUserInformationUseCase.invoke(model = model)
        }
    }
}
//************ EMAIL SIGN IN ************
//TODO ADD STORAGE MANAGER FOR SAVE TOKEN AND etc.
/*
    fun signInWithEmail(loginRequestModel: LoginRequestModel, navController: NavController) {
        isLoadingOrPopUp.value = true
        viewModelScope.launch {
            val response = loginService.loginToAccount(loginRequestModel)
            when (response.status) {
                Status.ERROR -> {
                    //TODO SHOW POP UP TO FOR WRONG LOGIN INFO
                    isLoadingOrPopUp.value = false
                }
                Status.SUCCESS -> {
                    isLoadingOrPopUp.value = false
                    navController.navigate(route = Screens.HomeUI.route) {
                        popUpTo(Screens.LoginUI.route) { inclusive = true }
                    }
                }
                else -> isLoadingOrPopUp.value = false
            }
        }
    }

    //************ GOOGLE SIGN IN ************
    fun signInWithGoogle(launcher: ManagedActivityResultLauncher<Intent, ActivityResult>) {
        isLoadingOrPopUp.value = true
        launcher.launch(googleClient.signInIntent)
        isLoadingOrPopUp.value = false
    }


    //************ GITHUB SIGN IN *************
    fun signInWithGithub() {}

}




 */
 */
 */

