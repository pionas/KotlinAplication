package pl.pionas.kotlinaplication.features.users.all.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.pionas.kotlinaplication.features.users.domain.model.User

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
@Parcelize
data class UserDisplayable(
    val id: Int?,
    val name: String?,
    val avatar: String?
) : Parcelable {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        avatar = user.avatar
    )

    companion object
}