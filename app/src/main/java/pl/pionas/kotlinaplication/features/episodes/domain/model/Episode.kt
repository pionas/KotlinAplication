package pl.pionas.kotlinaplication.features.episodes.domain.model

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {
    companion object
}