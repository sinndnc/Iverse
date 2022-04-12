package com.iverse.android

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.iverse.core.constant.NotificationConstant
import com.iverse.core.utils.navigation.NavigationDispatcher
import com.iverse.core.utils.notification.NotificationHelper
import com.iverse.core.utils.theme.ThemeSetting
import com.iverse.feature.component.theme.IverseTheme
import com.iverse.feature.navigation.graph.IverseNavGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    @Inject
    lateinit var notificationHelper: NotificationHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContent {
            val theme = themeSetting.themeStream.collectAsState()
            IverseTheme(theme.value) {
                ProvideWindowInsets {
                    IverseNavGraph(
                        navigationDispatcher = navigationDispatcher,
                        lifecycleOwner = this,
                    )
                }
            }
        }
    }


    private fun init() {
        notificationHelper.createChatNotificationChannel()
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }





}