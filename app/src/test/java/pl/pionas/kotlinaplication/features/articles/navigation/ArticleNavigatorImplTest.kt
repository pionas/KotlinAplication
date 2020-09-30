package pl.pionas.kotlinaplication.features.articles.navigation

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable
import pl.pionas.kotlinaplication.features.episodes.navigation.ArticleNavigatorImpl
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
internal class ArticleNavigatorImplTest {
    @Test
    fun `WHEN openArticleDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and article model as arguments`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val articleNavigator: ArticleNavigator = ArticleNavigatorImpl(fragmentNavigator)
        val article = ArticleDisplayable.mock()
        val slot = slot<Pair<String, ArticleDisplayable>>()

        // when
        articleNavigator.openArticleDetailsScreen(article)

        // then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_articles_screen_to_article_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe article
    }

    @Test
    fun `WHEN openArticleDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val articleNavigator: ArticleNavigator = ArticleNavigatorImpl(fragmentNavigator)
        val article = ArticleDisplayable.mock()
        val slot = slot<Pair<String, ArticleDisplayable>>()

        // when
        articleNavigator.goBack()

        // then
        verify {
            fragmentNavigator.goBack()
        }
    }

}