package pl.pionas.kotlinaplication.features.users.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 10 wrzesień 2020
 * adrian@pionka.com
 */
@Entity
data class UserCached(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val avatar: String?
) {

    constructor(user: User) : this(
        user.id,
        user.name,
        user.avatar
    )

    companion object

    fun toUser() = User(
        id = id,
        name = name,
        avatar = avatar
    )
}