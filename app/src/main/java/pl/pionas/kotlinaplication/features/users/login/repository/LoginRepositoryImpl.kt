package pl.pionas.kotlinaplication.features.users.login.repository

import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.exception.callOrThrow
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

class LoginRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : LoginRepository {
    override suspend fun login(user: User): User? {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getUserFromRemote(user)
            }
        } else {
            return null
        }
    }

    private suspend fun getUserFromRemote(user: User): User {
        return rickAndMortyApi.login(user).results
    }
}