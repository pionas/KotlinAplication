package pl.pionas.kotlinaplication.features.articles.navigation

import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable
import pl.pionas.kotlinaplication.features.articles.category.presentation.model.ArticleCategoryDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface ArticleNavigator {
    fun openArticleDetailsScreen(article: ArticleDisplayable)
    fun openArticleCategoryDetailsScreen(articleCategory: ArticleCategoryDisplayable)
    fun goBack()
}