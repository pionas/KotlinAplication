package pl.pionas.kotlinaplication.core.di

import pl.pionas.kotlinaplication.features.characters.di.characterModule
import pl.pionas.kotlinaplication.features.episodes.di.episodeModule
import pl.pionas.kotlinaplication.features.locations.di.locationModule
import pl.pionas.kotlinaplication.features.users.di.userModule

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val featureModules = listOf(
    characterModule,
    episodeModule,
    locationModule,
    userModule
)