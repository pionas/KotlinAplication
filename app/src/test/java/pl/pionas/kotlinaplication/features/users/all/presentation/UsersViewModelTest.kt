package pl.pionas.kotlinaplication.features.users.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.domain.GetUsersUseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.navigation.UserNavigator
import pl.pionas.kotlinaplication.mock.mock
import pl.pionas.kotlinaplication.utils.ViewModelTest
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */

internal class UsersViewModelTest : ViewModelTest() {
    @Test
    fun `WHEN user live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetUsersUseCase>(relaxed = true)
        val userNavigator = mockk<UserNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = UsersViewModel(useCase, userNavigator, errorMapper)

        // when
        viewModel.users.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN user live data is observed THEN invoke use case to get users`() {
        // given
        val useCase = mockk<GetUsersUseCase>(relaxed = true)
        val userNavigator = mockk<UserNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = UsersViewModel(useCase, userNavigator, errorMapper)

        // when
        viewModel.users.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result in success WHEN user live data is observed THEN set idle state AND set result in live data`() {
        // given
        val users = listOf(User.mock(), User.mock(), User.mock())
        val useCase = mockk<GetUsersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<User>>) -> Unit>()(Result.success(users))
            }
        }
        val userNavigator = mockk<UserNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = UsersViewModel(useCase, userNavigator, errorMapper)

        // when
        viewModel.users.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.users.getOrAwaitValue().forEachIndexed { index, userDisplayable ->
            val user = users[index]
            userDisplayable.name shouldBe user.name
        }
    }

    @Test
    fun `GIVEN use case result in success WHEN user live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetUsersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<User>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns "Ops... Something went wrong"
        }
        val userNavigator = mockk<UserNavigator>(relaxed = true)
        val viewModel = UsersViewModel(useCase, userNavigator, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.users.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }

    @Test
    fun `show user details screen after click on user list`() {
        // given
        val user = User.mock()
        val userDisplayable = UserDisplayable(user)
        val users = listOf(user, User.mock(), User.mock(), User.mock())
        val useCase = mockk<GetUsersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<User>>) -> Unit>()(Result.success(users))
            }
        }
        val userNavigator = mockk<UserNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = UsersViewModel(useCase, userNavigator, errorMapper)

        // when
        viewModel.users.observeForTesting()
        viewModel.users.value?.get(0)?.let {
            viewModel.onUserClick(it)
        }

        // then
        coVerify { userNavigator.openUserDetailsScreen(userDisplayable) }
    }
}