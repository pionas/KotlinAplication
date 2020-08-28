package pl.pionas.kotlinaplication.core.di

import org.koin.core.module.Module

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */

val koinInjector: List<Module> = featureModules
    .plus(networkModule)
    .plus(databaseModule)
    .plus(appModule)