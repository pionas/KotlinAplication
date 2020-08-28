package pl.pionas.kotlinaplication.features.locations.presentation.model

import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

data class LocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(location: Location) : this(
        name = location.name,
        url = location.url
    )
}