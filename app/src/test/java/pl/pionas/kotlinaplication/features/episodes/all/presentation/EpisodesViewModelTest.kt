package pl.pionas.kotlinaplication.features.episodes.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.pionas.kotlinaplication.features.episodes.domain.GetEpisodesUseCase
import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode
import pl.pionas.kotlinaplication.features.episodes.navigation.EpisodeNavigator
import pl.pionas.kotlinaplication.mock.mock
import pl.pionas.kotlinaplication.utils.ViewModelTest
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
internal class EpisodesViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode is clicked THAN open episode details screen`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)
        val episode = EpisodeDisplayable.mock()

        // when
        viewModel.onEpisodeClick(episode)

        // then
        verify { episodeNavigator.openEpisodeDetailsScreen(episode) }

    }

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {
        // given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.episodes.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result in success WHEN episode live data is observed THEN set idle state AND set result in live data`() {
        // given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }

    @Test
    fun `GIVEN use case result in success WHEN episode live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns "Ops... Something went wrong"
        }
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}