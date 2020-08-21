package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

data class ResponseInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
) {
    companion object
}