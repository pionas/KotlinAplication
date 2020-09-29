package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleStatisticRemote(
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("clicks")
    val clicks: Int,
    @SerializedName("clicks_unique")
    val clicksUnique: Int,
    @SerializedName("year")
    val year: Int,
    @SerializedName("month")
    val month: Int,
    @SerializedName("day")
    val day: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("article")
    val article: ArticleRemote
)