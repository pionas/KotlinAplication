package pl.pionas.kotlinaplication.features.locations.all.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.pionas.kotlinaplication.features.locations.domain.model.Location

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
@Parcelize
data class LocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(location: Location) : this(
        name = location.name,
        url = location.url
    )

    companion object
}