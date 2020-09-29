package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ForumPostRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("topic_id")
    val topicId: Int,
    @SerializedName("user_id")
    val userId: Int?,
    @SerializedName("guest_name")
    val guestName: String?,
    @SerializedName("guest_mail")
    val guestMail: String?,
    @SerializedName("visitor")
    val visitor: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("edited")
    val edited: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?
)