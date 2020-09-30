package pl.pionas.kotlinaplication.features.articles.category.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory
import java.util.*

@Parcelize
data class ArticleCategoryDisplayable(
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

) : Parcelable {
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
}