package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class UserThankResponse(
    @SerializedName("data")
    val `data`: List<UserThankRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)