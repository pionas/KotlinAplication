package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class UserRelationshipResponse(
    @SerializedName("data")
    val `data`: List<UserRelationshipRemote>?
) : BaseResponse() {
    companion object
}

data class UserRelationshipRemote(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_friend_id")
    val userFriendId: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("user")
    val user: UserRemote,
    @SerializedName("user_friend")
    val userFriend: UserRemote
)