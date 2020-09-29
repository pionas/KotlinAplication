package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class UserMessageResponse(
    @SerializedName("data")
    val `data`: List<UserMessageRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
) {
    companion object
}