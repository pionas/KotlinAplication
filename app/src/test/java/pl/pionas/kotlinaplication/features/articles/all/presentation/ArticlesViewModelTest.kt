package pl.pionas.kotlinaplication.features.articles.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.base.UiState
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable
import pl.pionas.kotlinaplication.features.articles.domain.GetArticlesUseCase
import pl.pionas.kotlinaplication.features.articles.domain.model.Article
import pl.pionas.kotlinaplication.features.articles.navigation.ArticleNavigator
import pl.pionas.kotlinaplication.mock.mock
import pl.pionas.kotlinaplication.utils.ViewModelTest
import pl.pionas.kotlinaplication.utils.getOrAwaitValue
import pl.pionas.kotlinaplication.utils.observeForTesting

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
internal class ArticlesViewModelTest : ViewModelTest() {
    @Test
    fun `WHEN article live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetArticlesUseCase>(relaxed = true)
        val articleNavigator = mockk<ArticleNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = ArticlesViewModel(useCase, articleNavigator, errorMapper)

        // when
        viewModel.articles.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN article live data is observed THEN invoke use case to get articles`() {
        // given
        val useCase = mockk<GetArticlesUseCase>(relaxed = true)
        val articleNavigator = mockk<ArticleNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = ArticlesViewModel(useCase, articleNavigator, errorMapper)

        // when
        viewModel.articles.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result in success WHEN article live data is observed THEN set idle state AND set result in live data`() {
        // given
        val articles = listOf(Article.mock(), Article.mock(), Article.mock())
        val useCase = mockk<GetArticlesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Article>>) -> Unit>()(Result.success(articles))
            }
        }
        val articleNavigator = mockk<ArticleNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = ArticlesViewModel(useCase, articleNavigator, errorMapper)

        // when
        viewModel.articles.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.articles.getOrAwaitValue().forEachIndexed { index, articleDisplayable ->
            val article = articles[index]
            articleDisplayable.title shouldBe article.title
            articleDisplayable.status shouldBe article.status
            articleDisplayable.content shouldBe article.content
        }
    }

    @Test
    fun `GIVEN use case result in success WHEN article live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetArticlesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Article>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val articleNavigator = mockk<ArticleNavigator>(relaxed = true)
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns "Ops... Something went wrong"
        }
        val viewModel = ArticlesViewModel(useCase, articleNavigator, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.articles.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }

    @Test
    fun `show article details screen after click on article list`() {
        // given
        val article = Article.mock()
        val articleDisplayable = ArticleDisplayable(article)
        val articles = listOf(article, Article.mock(), Article.mock(), Article.mock())
        val useCase = mockk<GetArticlesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Article>>) -> Unit>()(Result.success(articles))
            }
        }
        val articleNavigator = mockk<ArticleNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>()
        val viewModel = ArticlesViewModel(useCase, articleNavigator, errorMapper)

        // when
        viewModel.articles.observeForTesting()
        viewModel.articles.value?.get(0)?.let {
            viewModel.onArticleClick(it)
        }

        // then
        coVerify { articleNavigator.openArticleDetailsScreen(articleDisplayable) }
    }
}