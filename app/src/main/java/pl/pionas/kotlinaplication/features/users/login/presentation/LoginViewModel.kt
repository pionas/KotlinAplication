package pl.pionas.kotlinaplication.features.users.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.users.domain.GetAuthUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.presentation.model.UserDisplayable

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
class LoginViewModel(
    private val getAuthUseCase: GetAuthUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _user = MutableLiveData<User>()

    val user: LiveData<UserDisplayable> by lazy {
        _user.map { user ->
            UserDisplayable(user)
        }
    }

    fun auth(username: String, password: String) {
        val user = User(username = username, password = password)
        setPendingState()
        getAuthUseCase(
            params = user,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { _user.value = it }
            result.onFailure {
                handleFailure(it)
            }
        }
    }

    fun validate(username: String, password: String) {
        var usernameError: Int? = null
        var passwordError: Int? = null
        var isDataValid = true
        if (username.isEmpty()) {
            usernameError = R.string.username_cant_be_empty
            isDataValid = false
        }
        if (password.length < 4) {
            passwordError = R.string.password_cant_be_too_short
            isDataValid = false
        }

        _loginForm.value = LoginFormState(usernameError, passwordError, isDataValid)
    }
}