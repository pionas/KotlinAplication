package pl.pionas.kotlinaplication.features.users.login.presentation

import pl.pionas.kotlinaplication.features.users.AuthState

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
data class LoginFormState(
    val authState: AuthState? = null
)