package pl.pionas.kotlinaplication.features.locations.navigation

import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}