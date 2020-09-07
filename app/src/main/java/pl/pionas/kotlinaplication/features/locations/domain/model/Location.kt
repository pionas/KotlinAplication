package pl.pionas.kotlinaplication.features.locations.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */

@Parcelize
data class Location(
    val name: String,
    val url: String
) : Parcelable {
    companion object
}
