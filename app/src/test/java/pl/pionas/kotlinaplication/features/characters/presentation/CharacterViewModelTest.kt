package pl.pionas.kotlinaplication.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.characters.domain.GetCharactersUseCase
import pl.pionas.kotlinaplication.features.characters.domain.model.Character
import pl.pionas.kotlinaplication.mock.mock
import pl.pionas.kotlinaplication.utils.ViewModelTest
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
internal class CharacterViewModelTest : ViewModelTest() {
    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        // given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result in success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        // given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.status shouldBe character.status
            characterDisplayable.type shouldBe character.type
        }
    }

    @Test
    fun `GIVEN use case result in success WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns "Ops... Something went wrong"
        }
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}