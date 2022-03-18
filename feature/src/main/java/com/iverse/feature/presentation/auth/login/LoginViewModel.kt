package com.iverse.feature.presentation.auth.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import com.iverse.core.base.BaseViewModel
import com.iverse.core.domain.usecase.network.CheckNetworkUseCase
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.core.utils.navigation.NavigationDispatcher
import com.iverse.core.utils.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//TODO EDIT THIS CLASS
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    private val firebaseAuth: FirebaseAuth,
    checkNetworkUseCase: CheckNetworkUseCase,
) : BaseViewModel() {

    override val isNetwork: MutableState<NetworkState> = checkNetworkUseCase.isNetwork
    override val isLoading: MutableState<Boolean> = mutableStateOf(false)
    override val isPopUp: MutableState<Boolean> = mutableStateOf(false)

    //TODO( ADD STORAGE MANAGER FOR SAVE TOKEN AND etc.)
    fun loginToAccountWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { result ->
            if (result.isSuccessful){
                navigationDispatcher.dispatchNavigationCommand { navController ->
                    navController.popBackStack()
                    navController.navigate(Screens.MainUI.route)
                }
            }
        }

    }


}
