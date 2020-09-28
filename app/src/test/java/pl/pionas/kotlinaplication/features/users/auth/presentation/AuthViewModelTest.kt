package pl.pionas.kotlinaplication.features.users.auth.presentation

import androidx.lifecycle.Observer
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.core.provider.StringProvider
import pl.pionas.kotlinaplication.features.users.domain.AuthUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.navigation.UserNavigator
import pl.pionas.kotlinaplication.utils.ViewModelTest
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
internal class AuthViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN user live data is observed THEN set idle state`() {
        // given
        val useCase = mockk<AuthUseCase>(relaxed = true)
        val stringProvider = mockk<StringProvider>()
        val userNavigator = mockk<UserNavigator>()
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = AuthViewModel(useCase, stringProvider, userNavigator, errorMapper)

        // when
        viewModel.uiState.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
    }

    @Test
    fun `show error when username is empty`() {
        // given
        val error = "Username can't be empty!"
        val useCase = mockk<AuthUseCase>(relaxed = true)
        val stringProvider = mockk<StringProvider>(relaxed = true) {
            every { getString(R.string.username_cant_be_empty) } returns error
        }
        val userNavigator = mockk<UserNavigator>()
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = AuthViewModel(useCase, stringProvider, userNavigator, errorMapper)

        //when
        viewModel.loginClicked()

        //then
        viewModel.usernameError.value.equals(error)
    }

    @Test
    fun `show error when password is too short`() {
        //given
        val error = "Password must contain at least 4 characters!"
        val useCase = mockk<AuthUseCase>(relaxed = true)
        val stringProvider = mockk<StringProvider>() {
            every { getString(R.string.password_cant_be_too_short) } returns error
        }
        val userNavigator = mockk<UserNavigator>()
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = AuthViewModel(useCase, stringProvider, userNavigator, errorMapper)

        //when
        viewModel.username.value = "test" //valid username
        viewModel.password.value = "x" //password too short
        viewModel.loginClicked()


        //then
        viewModel.passwordError.value.equals(error)
    }

    @Test
    fun `GIVEN use case result in success WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val error = "Ops... Something went wrong"
        val throwable = Throwable(error)
        val observer = mockk<Observer<String>>(relaxed = true)
        val useCase = mockk<AuthUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<User>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val stringProvider = mockk<StringProvider>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns error
        }
        val userNavigator = mockk<UserNavigator>(relaxed = true)
        val viewModel = AuthViewModel(useCase, stringProvider, userNavigator, errorMapper)

        // when
        viewModel.username.value = "test"
        viewModel.password.value = "test"
        viewModel.message.observeForever(observer)
        viewModel.username.observeForTesting()
        viewModel.password.observeForTesting()
        viewModel.loginClicked()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}