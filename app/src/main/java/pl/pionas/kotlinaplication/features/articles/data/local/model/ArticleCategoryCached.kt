package pl.pionas.kotlinaplication.features.articles.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory
import java.util.*

@Entity
class ArticleCategoryCached(
    @PrimaryKey
    val id: Int,
    val categoryName: String,
    val description: String?,
    val categoryId: Int?,
    val slug: String,
    val order: Int?,
    val createdAt: Date,
    val updatedAt: Date?,
    val getParent: Int?,
    val articlesCount: Int?
) {
    constructor(articleCategory: ArticleCategory) : this(
        id = articleCategory.id,
        categoryName = articleCategory.categoryName,
        description = articleCategory.description,
        categoryId = articleCategory.categoryId,
        slug = articleCategory.slug,
        order = articleCategory.order,
        createdAt = articleCategory.createdAt,
        updatedAt = articleCategory.updatedAt,
        getParent = articleCategory.getParent,
        articlesCount = articleCategory.articlesCount
    )

    companion object

    fun toArticleCategory() = ArticleCategory(
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