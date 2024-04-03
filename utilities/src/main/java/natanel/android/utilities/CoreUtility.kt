package natanel.android.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

object CoreUtility {

    //Checks If there is internet connection
    fun isInterenetConnected(context: Context): Boolean {

        //Getting connectivity manager that provides information about the device's network connectivity.
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        //Retrieves the currently active network
        val networkCapabilities = connectivityManager.activeNetwork ?: return false

        //Get information about its capabilities, such as the network type (cellular, wifi, ethernet etc.)
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        //Checks network capabilities
        val result = when{
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true //cellular data (3G,4G,5G)
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true //Wi-Fi network
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true //wired ethernet connection (desktop/laptop)
            else -> false
        }
        return result

    }
}