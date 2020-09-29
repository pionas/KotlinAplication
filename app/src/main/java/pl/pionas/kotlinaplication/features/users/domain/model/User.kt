package pl.pionas.kotlinaplication.features.users.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
@Parcelize
data class User(
    val id: Int?,
    val name: String?,
    val avatar: String?,
    val createdAt: String? = null,
    val lastActive: Date? = null
) : Parcelable {
    companion object
}
