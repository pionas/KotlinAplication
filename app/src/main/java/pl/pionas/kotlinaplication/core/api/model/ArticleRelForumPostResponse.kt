package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ArticleRelForumPostResponse(
    @SerializedName("data")
    val `data`: List<ArticleRelForumPostRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)