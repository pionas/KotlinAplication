package pl.pionas.kotlinaplication.features.users.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
@Parcelize
data class User(
    val id: Int?,
    val name: String?,
    val avatar: String?
) : Parcelable {
    companion object
}
