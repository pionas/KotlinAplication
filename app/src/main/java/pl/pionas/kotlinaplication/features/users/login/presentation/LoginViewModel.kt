package pl.pionas.kotlinaplication.features.users.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.users.UserValidateUtils
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.domain.AuthUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
class LoginViewModel(
    private val authUseCase: AuthUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _loginForm by lazy {
        MutableLiveData<LoginFormState>()
    }
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _user by lazy {
        MutableLiveData<User>()
    }

    val user: LiveData<UserDisplayable> by lazy {
        _user.map { user ->
            UserDisplayable(user)
        }
    }

    fun auth(username: String, password: String) {
        val user = UserCredential(username = username, password = password)
        setPendingState()
        authUseCase(
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
        UserValidateUtils.validate(_loginForm, username, password)
    }
}