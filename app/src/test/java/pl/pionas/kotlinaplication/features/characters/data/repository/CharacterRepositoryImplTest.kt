package pl.pionas.kotlinaplication.features.characters.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.api.model.CharacterResponse
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.characters.data.local.CharacterDao
import pl.pionas.kotlinaplication.features.characters.data.local.model.CharacterCached
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
internal class CharacterRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharacterResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }

        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharacterResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }

        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val characterDao = mockk<CharacterDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns false
        }

        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { characterDao.getCharacters() }
    }
}