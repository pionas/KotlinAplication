package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ForumTopicWatchResponse(
    @SerializedName("data")
    val `data`: List<ForumTopicWatchRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)