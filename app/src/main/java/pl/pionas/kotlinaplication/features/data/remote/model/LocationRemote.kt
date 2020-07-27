package pl.pionas.kotlinaplication.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.characters.domain.model.Location

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

data class LocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toLocation() = Location(
        name = name,
        url = url
    )
}