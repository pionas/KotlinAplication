package pl.pionas.kotlinaplication.features.episodes.data.repository

import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}