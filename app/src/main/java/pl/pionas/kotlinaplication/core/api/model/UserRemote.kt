package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.users.domain.model.User
import java.util.*

data class UserRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("last_active") val lastActive: Date
) {
    companion object

    fun toUser() = User(
        id = id,
        name = name,
        avatar = avatar,
        createdAt = createdAt,
        lastActive = lastActive
    )
}