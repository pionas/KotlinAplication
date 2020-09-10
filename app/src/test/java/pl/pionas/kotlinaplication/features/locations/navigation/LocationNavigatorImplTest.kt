package pl.pionas.kotlinaplication.features.locations.navigation

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
internal class LocationNavigatorImplTest {
    @Test
    fun `WHEN openLocationDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and location model as arguments`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, LocationDisplayable>>()

        // when
        locationNavigator.openLocationDetailsScreen(location)

        // then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_locations_screen_to_location_details_screen, capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `WHEN openLocationDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        // when
        locationNavigator.goBack()

        // then
        verify {
            fragmentNavigator.goBack()
        }
    }

}