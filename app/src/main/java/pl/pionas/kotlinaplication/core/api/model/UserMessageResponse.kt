package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class UserMessageResponse(
    @SerializedName("data")
    val `data`: List<UserMessageRemote>?
) : BaseResponse() {
    companion object
}

data class UserMessageRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("subject")
    val subject: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("deleted_at")
    val deletedAt: Date,
    @SerializedName("participants")
    val userMessageParticipantRemotes: List<UserMessageParticipantRemote>
)

data class UserMessageParticipantRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("thread_id")
    val threadId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("last_read")
    val lastRead: Date?,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("deleted_at")
    val deletedAt: Date?
)