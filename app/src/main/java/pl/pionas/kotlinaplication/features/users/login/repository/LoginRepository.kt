package pl.pionas.kotlinaplication.features.users.login.repository

import pl.pionas.kotlinaplication.features.users.domain.model.User


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
interface LoginRepository {
    suspend fun login(user: User): User?
}