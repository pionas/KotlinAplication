package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ForumTopicRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("forum_id")
    val forumId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("guest_name")
    val guestName: String?,
    @SerializedName("guest_mail")
    val guestMail: String?,
    @SerializedName("visitor")
    val visitor: String?,
    @SerializedName("views")
    val views: Int,
    @SerializedName("posts")
    val posts: Int,
    @SerializedName("sticky")
    val sticky: Int,
    @SerializedName("closed")
    val closed: Int,
    @SerializedName("last_post_id")
    val lastPostId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?
)