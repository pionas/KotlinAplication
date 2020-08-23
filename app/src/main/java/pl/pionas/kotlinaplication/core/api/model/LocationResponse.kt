package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
class LocationResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
) {
    companion object
}