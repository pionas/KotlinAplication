package pl.pionas.kotlinaplication.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.characters.domain.model.Character


/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: OriginRemote,
    @SerializedName("location") val location: LocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toOrigin(),
        location = location.toLocation(),
        image = image,
        episode = episode,
        url = url
    )
}

