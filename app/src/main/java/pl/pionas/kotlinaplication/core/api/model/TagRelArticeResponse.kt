package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class TagRelArticeResponse(
    @SerializedName("data")
    val `data`: List<TagRelArticeRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)