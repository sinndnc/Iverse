package com.iverse.feature.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.iverse.core.utils.navigation.BottomNavigationDispatcher
import com.iverse.core.utils.navigation.NavigationDispatcher
import com.iverse.core.utils.qualifiers.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @DefaultDispatcher  private val dispatcher: CoroutineDispatcher,
    private val bottomNavigationDispatcher: BottomNavigationDispatcher,
) : ViewModel() {

    fun navigateTo(route: String) {
        viewModelScope.launch(dispatcher){
            bottomNavigationDispatcher.dispatchNavigationCommand { navController ->
                navController.navigate(route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

}