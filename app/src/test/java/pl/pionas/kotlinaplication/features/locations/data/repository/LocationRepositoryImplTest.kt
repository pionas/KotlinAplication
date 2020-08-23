package pl.pionas.kotlinaplication.features.locations.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.api.model.LocationResponse
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.locations.LocationRepository
import pl.pionas.kotlinaplication.features.locations.data.local.LocationDao
import pl.pionas.kotlinaplication.features.locations.data.local.model.LocationCached
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
internal class LocationRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns false
        }

        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { locationDao.getLocations() }
    }
}