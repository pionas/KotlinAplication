package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.users.domain.model.User

data class UserRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: String
) {
    companion object

    fun toUser() = User(
        id = id,
        name = name,
        avatar = avatar
    )
}