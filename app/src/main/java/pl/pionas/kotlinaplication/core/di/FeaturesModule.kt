package pl.pionas.kotlinaplication.core.di

import pl.pionas.kotlinaplication.features.articles.di.articleModule
import pl.pionas.kotlinaplication.features.users.di.userModule

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val featureModules = listOf(
    articleModule,
    userModule
)