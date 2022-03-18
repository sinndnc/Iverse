package com.iverse.core.utils.navigation

import com.iverse.core.utils.event.SingleLiveEvent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


@ActivityRetainedScoped
class BottomNavigationDispatcher @Inject constructor() {

    val navigationEmitter: SingleLiveEvent<NavigationCommand> = SingleLiveEvent()

    fun dispatchNavigationCommand(navigationCommand: NavigationCommand) {
        navigationEmitter.postValue(navigationCommand)
    }

}