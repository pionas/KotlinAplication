package pl.pionas.kotlinaplication.features.users.auth.data.repository

import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import pl.pionas.kotlinaplication.core.api.Api
import pl.pionas.kotlinaplication.core.api.model.UserResponse
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.users.data.local.UserDao
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepositoryImpl
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
internal class AuthRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN auth request THEN fetch user from API`() {
        // given
        val user = UserCredential("username", "password")
        val api = mockk<Api>() {
            coEvery { auth(user) } returns UserResponse.mock()
        }
        val userDao = mockk<UserDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: UserRepository =
            UserRepositoryImpl(api, userDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.auth(user) }

        // then
        coVerify { api.auth(user) }
    }


    @Test
    fun `GIVEN network is disconnected WHEN auths request THEN set error message`() {
        // given
        val error = "Ops... Something went wrong"
        val throwable = Throwable(error)
        val user = UserCredential("username", "password")
        val api = mockk<Api> {
            coEvery { auth(user) } throws throwable
        }
        val userDao = mockk<UserDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider>()
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: UserRepository =
            UserRepositoryImpl(api, userDao, networkStateProvider, errorWrapper)

        // when
        runBlocking {
            assertThrows<Throwable> { repository.auth(user) }
        }

        // then
        coVerify { api.auth(user) }
    }
}