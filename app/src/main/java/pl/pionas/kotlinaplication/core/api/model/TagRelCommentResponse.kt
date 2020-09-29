package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class TagRelCommentResponse(
    @SerializedName("data")
    val `data`: List<TagRelCommentRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)