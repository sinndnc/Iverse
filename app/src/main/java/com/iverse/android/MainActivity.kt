package com.iverse.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.iverse.core.utils.connectivity.NetworkManager
import com.iverse.feature.component.theme.IverseTheme
import com.iverse.feature.navigation.IverseNavGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            IverseTheme {
                IverseNavGraph()
            }
        }
    }

}