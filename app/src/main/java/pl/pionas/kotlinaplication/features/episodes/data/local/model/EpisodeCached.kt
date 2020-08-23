package pl.pionas.kotlinaplication.features.episodes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

@Entity
data class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {

    constructor(episode: Episode) : this(
        episode.id,
        episode.name,
        episode.airDate,
        episode.code,
        episode.characters,
        episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}