package com.iverse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.utils.socket.SocketService
import com.iverse.core.utils.theme.ThemeSetting
import com.iverse.feature.component.theme.IverseTheme
import com.iverse.feature.navigation.IverseNavGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @Inject
    lateinit var socketService: SocketService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        socketService.invoke()
        setContent {
            val theme = themeSetting.themeStream.collectAsState()
            IverseTheme(theme.value) {
                ProvideWindowInsets {
                    IverseNavGraph()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        socketService.destroy()
    }

}