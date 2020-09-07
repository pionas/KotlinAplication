package pl.pionas.kotlinaplication.features.users.login.presentation

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)