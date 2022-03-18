package com.iverse.core.utils.navigation

import androidx.navigation.NavController
import com.iverse.core.utils.event.SingleLiveEvent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

typealias NavigationCommand = (NavController) -> Unit

/**
 * This class dispatches navigation events to the navigation controller, which observes [navigationEmitter].
 */
@ActivityRetainedScoped
class NavigationDispatcher @Inject constructor() {

    val navigationEmitter: SingleLiveEvent<NavigationCommand> = SingleLiveEvent()

    fun dispatchNavigationCommand(navigationCommand: NavigationCommand) {
        navigationEmitter.postValue(navigationCommand)
    }

}

