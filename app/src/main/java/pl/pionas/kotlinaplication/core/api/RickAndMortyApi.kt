package pl.pionas.kotlinaplication.core.api

import pl.pionas.kotlinaplication.core.api.model.CharacterResponse
import pl.pionas.kotlinaplication.core.api.model.EpisodesResponse
import pl.pionas.kotlinaplication.core.api.model.LocationResponse
import retrofit2.http.GET

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */
interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("location")
    suspend fun getLocations(): LocationResponse

}