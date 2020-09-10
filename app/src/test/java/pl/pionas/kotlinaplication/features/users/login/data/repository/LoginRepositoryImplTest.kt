package pl.pionas.kotlinaplication.features.users.login.data.repository

import androidx.lifecycle.Observer
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.api.model.UserResponse
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.users.domain.AuthUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginViewModel
import pl.pionas.kotlinaplication.mock.mock
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
internal class LoginRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN auth request THEN fetch user from API`() {
        val user = User("username", "password")
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { login(user) } returns UserResponse.mock()
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: LoginRepository =
            LoginRepositoryImpl(api, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.login(user) }

        // then
        coVerify { api.login(user) }
    }

    @Test
    fun `GIVEN use case result in success WHEN user live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<AuthUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<User>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns "Ops... Something went wrong"
        }
        val viewModel = LoginViewModel(useCase, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.user.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}