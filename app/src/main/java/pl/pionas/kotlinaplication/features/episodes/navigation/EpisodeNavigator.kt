package pl.pionas.kotlinaplication.features.episodes.navigation

import pl.pionas.kotlinaplication.features.episodes.all.presentation.model.EpisodeDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}