package pl.pionas.kotlinaplication.features.articles.data.repository

import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory

interface ArticleCategoryRepository {
    suspend fun getArticlesCategories(): List<ArticleCategory>
}