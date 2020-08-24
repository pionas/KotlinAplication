package pl.pionas.kotlinaplication.core.di

import org.koin.core.module.Module
import pl.pionas.kotlinaplication.features.episodes.di.episodeModule

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val featureModules = listOf<Module>(
    episodeModule
)