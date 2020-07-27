package pl.pionas.kotlinaplication.features.locations.domain.model

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
)
