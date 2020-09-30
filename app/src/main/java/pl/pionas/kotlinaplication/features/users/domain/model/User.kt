package pl.pionas.kotlinaplication.features.users.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
@Parcelize
data class User(
    val id: Int?,
    val name: String?,
    val avatar: String?,
    val createdAt: Date?,
    val lastActive: Date?,
    val userFieldsValues: HashMap<String, String>?
) : Parcelable {
    companion object
}
