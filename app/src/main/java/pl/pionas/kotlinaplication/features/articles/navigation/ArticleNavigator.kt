package pl.pionas.kotlinaplication.features.articles.navigation

import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface ArticleNavigator {
    fun openArticleDetailsScreen(article: ArticleDisplayable)
    fun goBack()
}