package pl.pionas.kotlinaplication.features.articles.data.repository

import pl.pionas.kotlinaplication.core.api.Api
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.exception.callOrThrow
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.articles.data.local.ArticleDao
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCached
import pl.pionas.kotlinaplication.features.articles.domain.model.Article

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
class ArticleRepositoryImpl(
    private val api: Api,
    private val articleDao: ArticleDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getArticlesFromRemote()
            }.also { saveArticlesToLocal(it) }
        } else {
            getArticlesFromLocal()
        }
    }

    private suspend fun getArticlesFromRemote(): List<Article> {
        return api.getArticles()
            .data?.let {
                it.map {
                    it.toArticle()
                }
            } ?: emptyList()
    }

    private suspend fun saveArticlesToLocal(articles: List<Article>) {
        articles.map { ArticleCached(it) }
            .toTypedArray()
            .let { articleDao.saveArticles(*it) }
    }

    private suspend fun getArticlesFromLocal(): List<Article> {
        return articleDao.getArticles()
            .map { it.toArticle() }
    }

}