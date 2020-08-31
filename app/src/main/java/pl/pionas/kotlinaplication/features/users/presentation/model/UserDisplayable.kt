package pl.pionas.kotlinaplication.features.users.presentation.model

import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
data class UserDisplayable(
    val id: Int?,
    val name: String?,
    val username: String,
    val password: String?,
    val email: String?
) {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        username = user.username,
        password = user.password,
        email = user.email
    )
}