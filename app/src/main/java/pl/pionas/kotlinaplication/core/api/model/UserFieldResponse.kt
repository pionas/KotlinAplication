package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class UserFieldResponse(
    @SerializedName("data")
    val `data`: List<UserFieldRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)