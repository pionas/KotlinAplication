package pl.pionas.kotlinaplication.features.locations.navigation

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable
import pl.pionas.kotlinaplication.features.locations.details.presentation.LocationDetailsFragment

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : LocationNavigator {
    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_locations_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}