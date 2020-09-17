package pl.pionas.kotlinaplication.core.api

import pl.pionas.kotlinaplication.core.api.model.CharacterResponse
import pl.pionas.kotlinaplication.core.api.model.EpisodesResponse
import pl.pionas.kotlinaplication.core.api.model.LocationResponse
import pl.pionas.kotlinaplication.core.api.model.UserResponse
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */
interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("location")
    suspend fun getLocations(): LocationResponse

    @GET("login")
    suspend fun login(@Body user: UserCredential): UserResponse

    @GET("user")
    suspend fun getUsers(): UserResponse

    @GET("user/{username}")
    suspend fun getUser(@Path("username") username: String): UserResponse

}