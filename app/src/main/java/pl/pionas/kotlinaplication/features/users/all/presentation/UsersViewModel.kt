package pl.pionas.kotlinaplication.features.users.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.domain.GetUsersUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.navigation.UserNavigator

public class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val userNavigator: UserNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {
    private val _users by lazy {
        MutableLiveData<List<User>>()
            .also {
                getUsers(it)
            }
    }

    val users: LiveData<List<UserDisplayable>> by lazy {
        _users.map { episodes ->
            episodes.map { UserDisplayable(it) }
        }
    }

    private fun getUsers(userLiveData: MutableLiveData<List<User>>) {
        setPendingState()
        getUsersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { userLiveData.value = it }
            result.onFailure {
                handleFailure(it)
            }
        }
    }

    fun onUserClick(user: UserDisplayable) {
        userNavigator.openUserDetailsScreen(user)
    }
}