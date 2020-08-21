package pl.pionas.kotlinaplication.features.locations.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Entity
data class LocationCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {

    constructor(episode: Location) : this(
        episode.id,
        episode.name,
        episode.type,
        episode.dimension,
        episode.residents,
        episode.url
    )

    companion object

    fun toLocation() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url
    )
}