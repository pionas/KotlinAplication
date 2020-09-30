package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory
import java.util.*

data class ArticleCategoryResponse(
    @SerializedName("data")
    val `data`: List<ArticleCategoryRemote>?
) : BaseResponse() {
    companion object
}

data class ArticleCategoryRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("getparent")
    val getParent: Int?,
    @SerializedName("articles_count")
    val articlesCount: Int?
) {
    companion object

    fun toArticleCategory(): ArticleCategory {
        return ArticleCategory(
            id = id,
            categoryName = categoryName,
            description = description,
            categoryId = categoryId,
            slug = slug,
            order = order,
            createdAt = createdAt,
            updatedAt = updatedAt,
            getParent = getParent,
            articlesCount = articlesCount
        )
    }
}