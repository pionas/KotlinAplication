package pl.pionas.kotlinaplication.features.articles.details.presentation

import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class ArticleViewModel : BaseViewModel() {
    var articleDisplayable: ArticleDisplayable? = null
}