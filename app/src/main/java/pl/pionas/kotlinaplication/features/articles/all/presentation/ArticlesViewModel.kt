package pl.pionas.kotlinaplication.features.articles.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable
import pl.pionas.kotlinaplication.features.articles.domain.GetArticlesUseCase
import pl.pionas.kotlinaplication.features.articles.domain.model.Article
import pl.pionas.kotlinaplication.features.articles.navigation.ArticleNavigator

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
class ArticlesViewModel(
    private val getArticlesUseCase: GetArticlesUseCase,
    private val articleNavigator: ArticleNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {
    private val _articles by lazy {
        MutableLiveData<List<Article>>()
            .also {
                getArticles(it)
            }
    }

    val articles: LiveData<List<ArticleDisplayable>> by lazy {
        _articles.map { articles ->
            articles.map { ArticleDisplayable(it) }
        }
    }

    private fun getArticles(articleLiveData: MutableLiveData<List<Article>>) {
        setPendingState()
        getArticlesUseCase(
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

    fun onArticleClick(article: ArticleDisplayable) {
        articleNavigator.openArticleDetailsScreen(article)
    }
}