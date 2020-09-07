package pl.pionas.kotlinaplication.features.users.login.presentation

import io.mockk.mockk
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.users.domain.GetAuthUseCase
import pl.pionas.kotlinaplication.utils.ViewModelTest
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
internal class LoginViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN user live data is observed THEN set idle state`() {
        // given
        val useCase = mockk<GetAuthUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = LoginViewModel(useCase, errorMapper)

        // when
        viewModel.user.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
    }

}