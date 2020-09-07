package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */

data class UserResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: User
) {
    companion object
}