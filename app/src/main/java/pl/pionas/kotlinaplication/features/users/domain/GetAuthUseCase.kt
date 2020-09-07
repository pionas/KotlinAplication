package pl.pionas.kotlinaplication.features.users.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.users.domain.model.User
import pl.pionas.kotlinaplication.features.users.login.repository.LoginRepository

/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class GetAuthUseCase(private val loginRepository: LoginRepository) :
    UseCase<User?, User>() {
    override suspend fun action(params: User) = loginRepository.login(params)
}