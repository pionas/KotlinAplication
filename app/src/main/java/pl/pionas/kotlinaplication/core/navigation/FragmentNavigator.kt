package pl.pionas.kotlinaplication.core.navigation

import androidx.annotation.IdRes

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface FragmentNavigator {

    fun navigateTo(
        @IdRes destinationId: Int,
        fragmentTransition: FragmentTransition? = null
    )

    fun <T> navigateTo(
        @IdRes destinationId: Int,
        param: Pair<String, T>? = null,
        fragmentTransition: FragmentTransition? = null
    )

    fun goBack(
        @IdRes destinationId: Int? = null,
        inclusive: Boolean = false
    )

    fun clearHistory()
}