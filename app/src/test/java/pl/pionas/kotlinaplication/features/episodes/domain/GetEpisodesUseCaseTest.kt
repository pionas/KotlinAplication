package pl.pionas.kotlinaplication.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.features.episodes.EpisodeRepository


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoked than execute getEpisodes method from repository`() {
        // given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getEpisodes() }
    }
}