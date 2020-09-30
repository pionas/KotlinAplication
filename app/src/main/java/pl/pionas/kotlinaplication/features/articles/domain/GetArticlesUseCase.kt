package pl.pionas.kotlinaplication.features.articles.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleRepository
import pl.pionas.kotlinaplication.features.articles.domain.model.Article


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class GetArticlesUseCase(private val articleRepository: ArticleRepository) :
    UseCase<List<Article>, Unit>() {
    override suspend fun action(params: Unit) = articleRepository.getArticles()
}