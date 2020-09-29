package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

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