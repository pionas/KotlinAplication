package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleNotificationRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("date_notify")
    val dateNotify: Date,
    @SerializedName("type_notify")
    val typeNotify: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("article")
    val article: ArticleRemote,
    @SerializedName("user")
    val user: UserRemote
)