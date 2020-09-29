package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleSignatureRemote(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("user")
    val user: UserRemote,
    @SerializedName("article")
    val article: ArticleRemote
)