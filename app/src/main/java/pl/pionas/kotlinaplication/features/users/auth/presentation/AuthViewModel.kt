package pl.pionas.kotlinaplication.features.users.auth.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.core.provider.StringProvider
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.domain.AuthUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential
import pl.pionas.kotlinaplication.features.users.navigation.UserNavigator

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
public class AuthViewModel(
    private val authUseCase: AuthUseCase,
    private val stringProvider: StringProvider,
    private val userNavigator: UserNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    val username = MutableLiveData("")
    val usernameError = MutableLiveData<String>(null)
    val password = MutableLiveData("")
    val passwordError = MutableLiveData<String>(null)

    fun loginClicked() {
        usernameError.value = null
        passwordError.value = null

        val username = username.value!!
        val password = password.value!!
        var isValid = true
        if (username.isEmpty()) {
            usernameError.value = stringProvider.getString(R.string.username_cant_be_empty)
            isValid = false
        }
        if (password.length < 4) {
            passwordError.value = stringProvider.getString(R.string.password_cant_be_too_short)
            isValid = false
        }
        if (!isValid) {
            return
        }
        auth(username, password)
    }

    fun auth(username: String, password: String) {
        val user = UserCredential(username = username, password = password)
        setPendingState()
        authUseCase(
            params = user,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { loginSuccessful(UserDisplayable(it!!)) }
            result.onFailure {
                handleFailure(it)
            }
        }
    }

    private fun loginSuccessful(user: UserDisplayable) {
        userNavigator.authSuccessful(user)
    }
}