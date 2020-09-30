package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class TagRelArticeResponse(
    @SerializedName("data")
    val `data`: List<TagRelArticeRemote>?
) : BaseResponse() {
    companion object
}

data class TagRelArticeRemote(
    @SerializedName("tag_id")
    val tagId: Int,
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("tag")
    val tag: TagRemote,
    @SerializedName("article")
    val article: ArticleRemote
)