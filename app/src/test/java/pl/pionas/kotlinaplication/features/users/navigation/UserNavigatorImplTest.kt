package pl.pionas.kotlinaplication.features.users.navigation

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */
internal class UserNavigatorImplTest {
    @Test
    fun `WHEN openUserDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and user model as arguments`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val userNavigator: UserNavigator = UserNavigatorImpl(fragmentNavigator)
        val user = UserDisplayable.mock()
        val slot = slot<Pair<String, UserDisplayable>>()

        // when
        userNavigator.openUserDetailsScreen(user)

        // then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_users_screen_to_user_details_screen, capture(slot)
            )
        }
        slot.captured.second shouldBe user
    }

    @Test
    fun `WHEN openUserDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val userNavigator: UserNavigator = UserNavigatorImpl(fragmentNavigator)

        // when
        userNavigator.goBack()

        // then
        verify {
            fragmentNavigator.goBack()
        }
    }

}