package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class UserFieldOptionResponse(
    @SerializedName("data")
    val `data`: List<UserFieldOptionRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)