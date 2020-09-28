package pl.pionas.kotlinaplication.features.users.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.domain.model.UserCredential

/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class AuthUseCase(private val userRepository: UserRepository) :
    UseCase<User?, UserCredential>() {
    override suspend fun action(params: UserCredential) = userRepository.auth(params)
}