package pl.pionas.kotlinaplication.features.locations.presentation.model

import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

data class LocationDisplayable(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        residents = location.residents,
        url = location.url
    )
}