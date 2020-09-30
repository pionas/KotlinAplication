package pl.pionas.kotlinaplication.features.articles.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.core.api.Api
import pl.pionas.kotlinaplication.core.api.model.ArticleResponse
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.articles.data.local.ArticleDao
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCached
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
internal class ArticleRepositoryImplTest {
    @Test
    fun `GIVEN network is connected WHEN articles request THEN fetch articles from API`() {
        // given
        val api = mockk<Api>() {
            coEvery { getArticles() } returns ArticleResponse.mock()
        }
        val articleDao = mockk<ArticleDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: ArticleRepository =
            ArticleRepositoryImpl(api, articleDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getArticles() }

        // then
        coVerify { api.getArticles() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN articles request THEN save articles to local database`() {
        // given
        val api = mockk<Api>() {
            coEvery { getArticles() } returns ArticleResponse.mock()
        }
        val articleDao = mockk<ArticleDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: ArticleRepository =
            ArticleRepositoryImpl(api, articleDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getArticles() }

        // then
        coVerify { articleDao.saveArticles(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN articles request THEN fetch articles from local database`() {
        // given
        val api = mockk<Api>(relaxed = true)
        val articleDao = mockk<ArticleDao> {
            coEvery { getArticles() } returns listOf(
                ArticleCached.mock(),
                ArticleCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            coEvery { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>()

        val repository: ArticleRepository =
            ArticleRepositoryImpl(api, articleDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getArticles() }

        // then
        coVerify { articleDao.getArticles() }
    }
}