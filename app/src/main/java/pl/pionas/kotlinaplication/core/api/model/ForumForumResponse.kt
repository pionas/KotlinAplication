package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ForumForumResponse(
    @SerializedName("data")
    val `data`: List<ForumForumResponse>?
) : BaseResponse() {
    companion object
}

data class ForumForumRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_id")
    val categoryId: Int?,
    @SerializedName("title")
    val title: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("order")
    val order: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("topics")
    val topics: Int,
    @SerializedName("posts")
    val posts: Int,
    @SerializedName("last_post_id")
    val lastPostId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("forum_category")
    val forumCategory: ForumCategoryResponse,
    @SerializedName("forum_moderators")
    val forumModerators: List<UserRemote>
)