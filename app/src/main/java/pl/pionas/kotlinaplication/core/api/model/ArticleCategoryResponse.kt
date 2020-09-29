package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ArticleCategoryResponse(
    @SerializedName("data")
    val `data`: List<ArticleCategoryRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)