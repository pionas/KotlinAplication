package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */

data class UserResponse(
    @SerializedName("data")
    val `data`: List<UserRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
) {
    companion object
}