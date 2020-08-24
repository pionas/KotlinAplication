package pl.pionas.kotlinaplication.features.episodes.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.api.model.EpisodesResponse
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.episodes.data.local.EpisodeDao
import pl.pionas.kotlinaplication.features.episodes.data.local.model.EpisodeCached
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
internal class EpisodeRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }

        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN episodes request THEN save episodes to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }

        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns false
        }

        val repository: EpisodeRepository =
            EpisodeRepositoryImpl(api, episodeDao, networkStateProvider)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { episodeDao.getEpisodes() }
    }
}