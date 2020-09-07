package pl.pionas.kotlinaplication.features.characters.all.presentation.model

import pl.pionas.kotlinaplication.features.characters.domain.model.Origin

/**
 * Created by Adrian Pionka on 23 sierpień 2020
 * adrian@pionka.com
 */

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}