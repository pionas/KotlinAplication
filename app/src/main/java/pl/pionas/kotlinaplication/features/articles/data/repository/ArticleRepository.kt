package pl.pionas.kotlinaplication.features.articles.data.repository

import pl.pionas.kotlinaplication.features.articles.domain.model.Article

/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}