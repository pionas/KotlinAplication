package pl.pionas.kotlinaplication.features.articles.domain.model

import java.util.*

class ArticleCategory(
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
)