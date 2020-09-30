package pl.pionas.kotlinaplication.features.articles.category.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.articles.category.presentation.model.ArticleCategoryDisplayable
import pl.pionas.kotlinaplication.features.articles.domain.GetArticlesCategoriesUseCase
import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory
import pl.pionas.kotlinaplication.features.articles.navigation.ArticleNavigator

class ArticlesCategoriesViewModel(
    private val getArticlesCategoriesUseCase: GetArticlesCategoriesUseCase,
    private val articleNavigator: ArticleNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {
    private val _articlesCategories by lazy {
        MutableLiveData<List<ArticleCategory>>()
            .also {
                getArticlesCategories(it)
            }
    }

    val articlesCategories: LiveData<List<ArticleCategoryDisplayable>> by lazy {
        _articlesCategories.map { articles ->
            articles.map { ArticleCategoryDisplayable(it) }
        }
    }

    private fun getArticlesCategories(articleLiveData: MutableLiveData<List<ArticleCategory>>) {
        setPendingState()
        getArticlesCategoriesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { articleLiveData.value = it }
            result.onFailure {
                handleFailure(it)
            }
        }
    }

    fun onArticleCategoryClick(articleCategory: ArticleCategoryDisplayable) {
        articleNavigator.openArticleCategoryDetailsScreen(articleCategory)
    }
}