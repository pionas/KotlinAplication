package pl.pionas.kotlinaplication.features.users.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository
import pl.pionas.kotlinaplication.features.users.domain.model.User


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class GetUsersUseCase(private val userRepository: UserRepository) :
    UseCase<List<User>, Unit>() {
    override suspend fun action(params: Unit) = userRepository.getUsers()
}