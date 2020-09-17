package pl.pionas.kotlinaplication.features.users.details.presentation

import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class UserViewModel : BaseViewModel() {
    var userDisplayable: UserDisplayable? = null
}