package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleRelCategoryResponse(
    @SerializedName("data")
    val `data`: List<ArticleRelCategoryRemote>?
) : BaseResponse() {
    companion object
}
data class ArticleRelCategoryRemote(
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("article_category")
    val articleCategory: ArticleCategoryRemote,
    @SerializedName("article")
    val article: ArticleRemote
)