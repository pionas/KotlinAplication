package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class TagRelForumPostRemote(
    @SerializedName("tag_id")
    val tagId: Int,
    @SerializedName("post_id")
    val postId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("tag")
    val tag: TagRemote,
    @SerializedName("post")
    val post: ForumPostRemote
)