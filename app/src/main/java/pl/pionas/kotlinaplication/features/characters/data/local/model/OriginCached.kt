package pl.pionas.kotlinaplication.features.characters.data.local.model

import androidx.room.Entity
import pl.pionas.kotlinaplication.features.characters.domain.model.Origin

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
@Entity(primaryKeys = ["name", "url"])
class OriginCached(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        origin.name,
        origin.url
    )

    companion object

    fun toOrigin() = Origin(
        name = name,
        url = url
    )
}