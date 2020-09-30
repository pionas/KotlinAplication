package pl.pionas.kotlinaplication.core.api

import pl.pionas.kotlinaplication.core.api.model.*
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */
interface Api {

    @GET("articles")
    suspend fun getArticles(): ArticleResponse

    @GET("contests")
    suspend fun getArticlesCategories(): ArticleCategoryResponse

    @GET("forum")
    suspend fun getForum(): List<Any>

    @GET("auth")
    suspend fun auth(@Body user: UserCredential): UserResponse

    @GET("users")
    suspend fun getUsers(): UserResponse

    @GET("users/show/{username}")
    suspend fun getUser(@Path("username") username: String): UserResponse

}