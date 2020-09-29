package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class TagResponse(
    @SerializedName("data")
    val `data`: List<TagRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)