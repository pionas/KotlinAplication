package pl.pionas.kotlinaplication.features.episodes.navigation

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable
import pl.pionas.kotlinaplication.features.articles.details.presentation.ArticleDetailsFragment
import pl.pionas.kotlinaplication.features.articles.navigation.ArticleNavigator

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */

class ArticleNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    ArticleNavigator {
    override fun openArticleDetailsScreen(article: ArticleDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_articles_screen_to_article_details_screen,
            ArticleDetailsFragment.ARTICLE_DETAILS_KEY to article
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}