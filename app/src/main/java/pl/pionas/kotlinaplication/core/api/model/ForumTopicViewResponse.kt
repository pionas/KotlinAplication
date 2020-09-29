package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ForumTopicViewResponse(
    @SerializedName("data")
    val `data`: List<ForumTopicViewRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)