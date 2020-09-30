import pl.pionas.kotlinaplication.core.api.Api
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.exception.callOrThrow
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.articles.data.local.ArticleCategoryDao
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCategoryCached
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleCategoryRepository
import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory

class ArticleCategoryRepositoryImpl(
    private val api: Api,
    private val articleCategoryDao: ArticleCategoryDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : ArticleCategoryRepository {
    override suspend fun getArticlesCategories(): List<ArticleCategory> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getArticleCategorysFromRemote()
            }.also { saveArticleCategorysToLocal(it) }
        } else {
            getArticleCategorysFromLocal()
        }
    }

    private suspend fun getArticleCategorysFromRemote(): List<ArticleCategory> {
        return api.getArticlesCategories()
            .data?.let {
                it.map {
                    it.toArticleCategory()
                }
            } ?: emptyList()
    }

    private suspend fun saveArticleCategorysToLocal(articleCategorys: List<ArticleCategory>) {
        articleCategorys.map { ArticleCategoryCached(it) }
            .toTypedArray()
            .let { articleCategoryDao.saveArticlesCategories(*it) }
    }

    private suspend fun getArticleCategorysFromLocal(): List<ArticleCategory> {
        return articleCategoryDao.getArticlesCategories()
            .map { it.toArticleCategory() }
    }

}