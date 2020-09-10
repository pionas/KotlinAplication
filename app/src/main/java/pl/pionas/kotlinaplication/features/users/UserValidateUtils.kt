package pl.pionas.kotlinaplication.features.users

import androidx.lifecycle.MutableLiveData
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginFormState

/**
 * Created by Adrian Pionka on 09 wrzesień 2020
 * adrian@pionka.com
 */

sealed class AuthState {
    object UsernameIsEmpty : AuthState()
    object PasswordIsTooShort : AuthState()
}

class UserValidateUtils {
    companion object {
        fun validate(
            loginForm: MutableLiveData<LoginFormState>,
            username: String,
            password: String
        ) {
            var authState: AuthState? = null
            if (username.isEmpty()) {
                authState = AuthState.UsernameIsEmpty
            }
            if (password.length < 4) {
                authState = AuthState.PasswordIsTooShort
            }
            loginForm.value = LoginFormState(authState)
        }
    }
}