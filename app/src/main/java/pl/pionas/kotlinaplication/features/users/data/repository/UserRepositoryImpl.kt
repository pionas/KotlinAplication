package pl.pionas.kotlinaplication.features.users.data.repository

import pl.pionas.kotlinaplication.core.api.Api
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.exception.callOrThrow
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.users.data.local.UserDao
import pl.pionas.kotlinaplication.features.users.data.local.model.UserCached
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential

/**
 * Created by Adrian Pionka on 10 wrzesień 2020
 * adrian@pionka.com
 */
class UserRepositoryImpl(
    private val api: Api,
    private val userDao: UserDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : UserRepository {
    override suspend fun auth(user: UserCredential): User? {
        return callOrThrow(errorWrapper) {
            getUserFromRemote(user)
        }
    }

    private suspend fun getUserFromRemote(user: UserCredential): User {
        return api.auth(user).data?.let { it.get(0).toUser() }!!
    }

    override suspend fun getUsers(): List<User> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getUsersFromRemote()
            }.also { saveUsersToLocal(it) }
        } else {
            getUsersFromLocal()
        }
    }

    override suspend fun getUserByUsername(username: String): User? {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getUserByUsernameFromRemote(username)
            }.also { saveUsersToLocal(listOf(it)) }
        } else {
            getUserFromLocal(username)
        }
    }

    private suspend fun getUsersFromRemote(): List<User> {
        return api.getUsers()
            .data?.let {
                it.map { it.toUser() }
            } ?: emptyList()
    }


    private suspend fun getUsersFromLocal(): List<User> {
        return userDao.getUsers()
            .map { it.toUser() }
    }

    private suspend fun saveUsersToLocal(episodes: List<User>) {
        episodes.map { UserCached(it) }
            .toTypedArray()
            .let { userDao.saveUsers(*it) }
    }

    private suspend fun getUserByUsernameFromRemote(username: String): User {
        return api.getUser(username)
            .data?.let {
                it.get(0).toUser()
            }!!
    }

    private suspend fun getUserFromLocal(username: String): User {
        return userDao.getUser(username).toUser()
    }


}