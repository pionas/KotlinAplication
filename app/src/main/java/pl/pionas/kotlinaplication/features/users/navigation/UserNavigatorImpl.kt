package pl.pionas.kotlinaplication.features.users.navigation

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.details.presentation.UserDetailsFragment

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */
class UserNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : UserNavigator {
    override fun openUserDetailsScreen(user: UserDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_users_screen_to_user_details_screen,
            UserDetailsFragment.USER_DETAILS_KEY to user
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}