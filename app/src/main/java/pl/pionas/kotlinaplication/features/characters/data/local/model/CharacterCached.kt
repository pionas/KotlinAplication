package pl.pionas.kotlinaplication.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.characters.domain.model.Character
import pl.pionas.kotlinaplication.features.characters.domain.model.Origin
import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Entity
class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded(prefix = "origin_")
    val origin: Origin,
    @Embedded(prefix = "location_")
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        character.origin,
        character.location,
        character.image,
        character.episode,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin,
        location = location,
        image = image,
        episode = episode,
        url = url
    )
}