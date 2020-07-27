package pl.pionas.kotlinaplication.features.episodes.presentation.model

import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )
}