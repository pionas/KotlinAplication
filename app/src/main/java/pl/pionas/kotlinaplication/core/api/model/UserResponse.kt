package pl.pionas.kotlinaplication.core.api.model

import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.fragment_user_details.*
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.features.users.domain.model.User
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */
data class UserResponse(
    @SerializedName("data")
    val `data`: List<UserRemote>?
) : BaseResponse() {
    companion object
}


data class Users(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("data")
    val `data`: List<UserRemote>,
    @SerializedName("first_page_url")
    val firstPageUrl: String,
    @SerializedName("from")
    val from: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("last_page_url")
    val lastPageUrl: String,
    @SerializedName("next_page_url")
    val nextPageUrl: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("prev_page_url")
    val prevPageUrl: Any,
    @SerializedName("to")
    val to: Int,
    @SerializedName("total")
    val total: Int
)

data class UserRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: String?,
    @SerializedName("created_at") val createdAt: Date,
    @SerializedName("last_active") val lastActive: Date?,
    @SerializedName("users_fields_values") val userFieldsValues: HashMap<String, String>?
) {
    companion object

    fun toUser(): User {
        var avatarUrl = avatar
        userFieldsValues?.let {
            if (it.containsKey("users.avatar")) {
                val avatar = it.get("users.avatar")
                if (avatar!!.isNotEmpty()) {
                    avatarUrl = "https://www.e-konkursy.info/files/avatar/${avatar}"
                    println("######### avatarUrl=" + avatarUrl)
                }
            }
        }
        return User(
            id = id,
            name = name,
            avatar = avatarUrl,
            createdAt = createdAt,
            lastActive = lastActive,
            userFieldsValues = userFieldsValues
        )
    }
}