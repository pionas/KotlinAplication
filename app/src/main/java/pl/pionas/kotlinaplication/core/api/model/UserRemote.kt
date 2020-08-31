package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.users.domain.model.User

data class UserRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String
) {
    companion object

    fun toUser() = User(
        id = id,
        name = name,
        username = username,
        password = password,
        email = email
    )
}