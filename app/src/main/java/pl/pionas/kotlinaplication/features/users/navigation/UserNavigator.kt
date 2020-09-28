package pl.pionas.kotlinaplication.features.users.navigation

import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable


/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface UserNavigator {
    fun openUserDetailsScreen(user: UserDisplayable)
    fun goBack()
    fun authSuccessful(user: UserDisplayable)
}