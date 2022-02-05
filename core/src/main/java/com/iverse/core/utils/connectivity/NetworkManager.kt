package com.iverse.core.utils.connectivity

import android.annotation.SuppressLint
import android.content.Context
import android.net.*
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import java.net.InetSocketAddress
import javax.inject.Inject
import javax.net.SocketFactory


enum class NetworkState { CONNECTED, UNCONNECTED, RECONNECTED , SAFECONNECTED }

//TODO ADD DOES HAVE INTERNET OBJECT
class NetworkManager(private val connectivityManager: ConnectivityManager) : LiveData<NetworkState>() {
    val TAG = "NetworkReceiverTest"

    @Inject
    constructor(@ApplicationContext context: Context) : this(context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

    private val currentNetwork = connectivityManager.activeNetwork
    val checkInternet = connectivityManager.getNetworkCapabilities(currentNetwork)

    val timer = object : CountDownTimer(2000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            postValue(NetworkState.SAFECONNECTED)
        }
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            postValue(NetworkState.CONNECTED)
        }

        override fun onLost(network: Network) {
            timer.cancel()
            postValue(NetworkState.UNCONNECTED)
        }

        override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
            val hasCellular = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            val hasWifi = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            val hasActuallyConn = DoesNetworkHaveInternet.execute(network.socketFactory)
            if ((value == NetworkState.CONNECTED) && (hasCellular || hasWifi) && hasActuallyConn) {
                postValue(NetworkState.RECONNECTED)
                timer.start()
            }
        }
    }

    override fun onActive() {
        super.onActive()
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }


}

object DoesNetworkHaveInternet {
    fun execute(socketFactory: SocketFactory): Boolean {
        return try {
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null.")
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            true
        } catch (e: IOException) {
            false
        }
    }
}


