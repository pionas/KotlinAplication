package pl.pionas.kotlinaplication.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.characters.CharacterRepository
import pl.pionas.kotlinaplication.features.characters.domain.GetCharacterUseCase


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
internal class GetCharactersUseCaseTest {

    @Test
    fun `when use case is invoked than execute getCharacters method from repository`() {
        // given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharacterUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getCharacters() }
    }
}