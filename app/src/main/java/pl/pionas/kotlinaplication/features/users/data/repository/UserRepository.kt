package pl.pionas.kotlinaplication.features.users.data.repository

import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential

/**
 * Created by Adrian Pionka on 10 wrzesień 2020
 * adrian@pionka.com
 */
interface UserRepository {
    suspend fun login(user: UserCredential): User?
    suspend fun getUsers(): List<User>
    suspend fun getUserByUsername(username: String): User?
}