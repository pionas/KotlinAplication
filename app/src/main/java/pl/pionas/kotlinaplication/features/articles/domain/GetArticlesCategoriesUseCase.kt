package pl.pionas.kotlinaplication.features.articles.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleCategoryRepository
import pl.pionas.kotlinaplication.features.articles.domain.model.ArticleCategory


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class GetArticlesCategoriesUseCase(private val articleRepository: ArticleCategoryRepository) :
    UseCase<List<ArticleCategory>, Unit>() {
    override suspend fun action(params: Unit) = articleRepository.getArticlesCategories()
}