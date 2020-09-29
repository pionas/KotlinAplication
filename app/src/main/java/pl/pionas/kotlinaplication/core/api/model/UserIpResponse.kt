package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class UserIpResponse(
    @SerializedName("data")
    val `data`: List<UserIpRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)