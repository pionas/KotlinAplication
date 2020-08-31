package pl.pionas.kotlinaplication.features.users.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

@Entity
data class UserCached(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val username: String,
    val password: String?,
    val email: String?
) {

    constructor(user: User) : this(
        user.id,
        user.name,
        user.username,
        user.password,
        user.email
    )

    companion object

    fun toUser() = User(
        id = id,
        name = name,
        username = username,
        password = password,
        email = email
    )
}