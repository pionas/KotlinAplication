package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class CommentRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("user_id")
    val userId: Int?,
    @SerializedName("guest_name")
    val guestName: String?,
    @SerializedName("guest_mail")
    val guestMail: String?,
    @SerializedName("content")
    val content: String,
    @SerializedName("rank_p")
    val rankP: String,
    @SerializedName("rank_m")
    val rankM: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("hidden")
    val hidden: String,
    @SerializedName("visitor")
    val visitor: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?
)