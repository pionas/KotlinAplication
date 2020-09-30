package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class TagRelCommentResponse(
    @SerializedName("data")
    val `data`: List<TagRelCommentRemote>?
) : BaseResponse() {
    companion object
}

data class TagRelCommentRemote(
    @SerializedName("tag_id")
    val tagId: Int,
    @SerializedName("comment_id")
    val commentId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("tag")
    val tag: TagRemote,
    @SerializedName("comment")
    val comment: CommentRemote
)