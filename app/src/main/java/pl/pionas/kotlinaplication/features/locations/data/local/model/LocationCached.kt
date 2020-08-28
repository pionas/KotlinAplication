package pl.pionas.kotlinaplication.features.locations.data.local.model

import androidx.room.Entity
import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Entity(primaryKeys = ["name", "url"])
data class LocationCached(
    val name: String,
    val url: String
) {

    constructor(episode: Location) : this(
        episode.name,
        episode.url
    )

    companion object

    fun toLocation() = Location(
        name = name,
        url = url
    )
}