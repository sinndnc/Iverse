package com.iverse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.iverse.core.utils.navigation.BottomNavigationDispatcher
import com.iverse.core.utils.navigation.NavigationDispatcher
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
    lateinit var bottomNavigationDispatcher: BottomNavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val theme = themeSetting.themeStream.collectAsState()
            IverseTheme(theme.value) {
                ProvideWindowInsets {
                    IverseNavGraph(
                        navigationDispatcher = navigationDispatcher,
                        bottomNavigationDispatcher = bottomNavigationDispatcher,
                        lifecycleOwner = this,
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}