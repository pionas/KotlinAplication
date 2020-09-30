package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleIpResponse(
    @SerializedName("data")
    val `data`: List<ArticleIpRemote>?
) : BaseResponse() {
    companion object
}

data class ArticleIpRemote(
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("ip")
    val ip: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("article")
    val article: ArticleRemote
)