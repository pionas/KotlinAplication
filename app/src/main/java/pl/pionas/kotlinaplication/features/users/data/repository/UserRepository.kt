package pl.pionas.kotlinaplication.features.users.data.repository

import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 10 wrzesień 2020
 * adrian@pionka.com
 */
interface UserRepository {
    suspend fun login(user: User): User?
    suspend fun getUsers(): List<User>
    suspend fun getUserByUsername(username: String): User?
}