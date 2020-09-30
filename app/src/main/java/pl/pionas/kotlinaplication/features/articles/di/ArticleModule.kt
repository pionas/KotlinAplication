package pl.pionas.kotlinaplication.features.articles.di

import ArticleCategoryRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.articles.all.presentation.ArticlesAdapter
import pl.pionas.kotlinaplication.features.articles.all.presentation.ArticlesFragment
import pl.pionas.kotlinaplication.features.articles.all.presentation.ArticlesViewModel
import pl.pionas.kotlinaplication.features.articles.category.presentation.ArticlesCategoriesAdapter
import pl.pionas.kotlinaplication.features.articles.category.presentation.ArticlesCategoriesFragment
import pl.pionas.kotlinaplication.features.articles.category.presentation.ArticlesCategoriesViewModel
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleCategoryRepository
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleRepository
import pl.pionas.kotlinaplication.features.articles.data.repository.ArticleRepositoryImpl
import pl.pionas.kotlinaplication.features.articles.details.presentation.ArticleViewModel
import pl.pionas.kotlinaplication.features.articles.domain.GetArticlesCategoriesUseCase
import pl.pionas.kotlinaplication.features.articles.domain.GetArticlesUseCase
import pl.pionas.kotlinaplication.features.articles.navigation.ArticleNavigator
import pl.pionas.kotlinaplication.features.episodes.navigation.ArticleNavigatorImpl

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val articleModule = module {
    // data
    factory<ArticleRepository> { ArticleRepositoryImpl(get(), get(), get(), get()) }
    factory<ArticleCategoryRepository> { ArticleCategoryRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetArticlesUseCase(get()) }
    factory { GetArticlesCategoriesUseCase(get()) }

    // presentation
    factory<ArticleNavigator> { ArticleNavigatorImpl(get()) }
    viewModel { ArticlesViewModel(get(), get(), get()) }
    factory { ArticlesFragment() }
    factory { ArticlesAdapter(get()) }
    viewModel { ArticleViewModel() }

    viewModel { ArticlesCategoriesViewModel(get(), get(), get()) }
    factory { ArticlesCategoriesFragment() }
    factory { ArticlesCategoriesAdapter(get()) }
//    viewModel { ArticleCategoryViewModel() }
}