package com.iverse.feature.presentation.main.pages.message

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.information.UserInfoService
import com.iverse.core.utils.qualifiers.ID
import com.iverse.core.utils.socket.SocketService
import com.iverse.feature.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val userInfoService: UserInfoService,
    private val socketService: SocketService,
    @ID private val userId: String
) : ViewModel() {

    lateinit var id: String

    init {
        Log.d("IdTest", userId)
        viewModelScope.launch {
            id = userInfoService.getUserInformation(AuthPreferencesKeys.ID)
        }
    }

    fun loginToConversation(imageUrl: String, receiverId: String, username: String, navController: NavController) {
        socketService.attemptToChat(id)
        val photo = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())
        navController.navigate("${Screens.ChatUI.route}/$photo/${username}")
    }


}