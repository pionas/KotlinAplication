package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

data class LocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toLocation() = Location(
        name = name,
        url = url
    )
}