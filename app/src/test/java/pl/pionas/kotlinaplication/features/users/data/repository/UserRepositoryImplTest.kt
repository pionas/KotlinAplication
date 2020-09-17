package pl.pionas.kotlinaplication.features.users.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.api.model.UserResponse
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.users.data.local.UserDao
import pl.pionas.kotlinaplication.features.users.data.local.model.UserCached
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */

internal class UserRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN users request THEN fetch users from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getUsers() } returns UserResponse.mock()
        }
        val userDao = mockk<UserDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: UserRepository =
            UserRepositoryImpl(api, userDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getUsers() }

        // then
        coVerify { api.getUsers() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN users request THEN save users to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getUsers() } returns UserResponse.mock()
        }
        val userDao = mockk<UserDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: UserRepository =
            UserRepositoryImpl(api, userDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getUsers() }

        // then
        coVerify { userDao.saveUsers(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN users request THEN fetch users from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val userDao = mockk<UserDao> {
            coEvery { getUsers() } returns listOf(UserCached.mock(), UserCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: UserRepository =
            UserRepositoryImpl(api, userDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getUsers() }

        // then
        coVerify { userDao.getUsers() }
    }
}