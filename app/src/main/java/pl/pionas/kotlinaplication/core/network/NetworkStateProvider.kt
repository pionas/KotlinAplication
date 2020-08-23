package pl.pionas.kotlinaplication.core.network

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}