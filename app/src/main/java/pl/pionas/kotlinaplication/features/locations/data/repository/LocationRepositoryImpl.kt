package pl.pionas.kotlinaplication.features.locations.data.repository

import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.locations.LocationRepository
import pl.pionas.kotlinaplication.features.locations.data.local.LocationDao
import pl.pionas.kotlinaplication.features.locations.data.local.model.LocationCached
import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
class LocationRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {
    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote()
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .results
            .map { it.toLocation() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Location>) {
        episodes.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Location> {
        return locationDao.getLocations()
            .map { it.toLocation() }
    }
}