package pl.pionas.kotlinaplication.features.users.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Adrian Pionka on 17 wrzesień 2020
 * adrian@pionka.com
 */
@Parcelize
data class UserCredential(
    val username: String?,
    val password: String?
) : Parcelable {
    companion object
}