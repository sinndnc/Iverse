package com.iverse.feature.presentation.auth.splash


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.iverse.core.utils.navigation.NavigationDispatcher
import com.iverse.core.utils.qualifiers.DefaultDispatcher
import com.iverse.feature.navigation.HOME_GRAPH_ROUTE
import com.iverse.feature.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    private val navigationDispatcher: NavigationDispatcher,
    val firebaseAuth: FirebaseAuth,
) : ViewModel() {

    fun redirectToMain() {
        viewModelScope.launch(dispatcher) {
            navigationDispatcher.dispatchNavigationCommand { navController ->
                navController.popBackStack()
                navController.navigate(Screens.MainUI.route)
            }
        }
    }

    //TODO
    fun redirectToOnBoard() {
        viewModelScope.launch(dispatcher) {
            navigationDispatcher.dispatchNavigationCommand { navController ->
                navController.popBackStack()
                navController.navigate(Screens.LoginUI.route)
            }
        }
    }

}

