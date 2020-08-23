package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

data class CharacterResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}