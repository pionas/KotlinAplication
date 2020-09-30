package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class TagResponse(
    @SerializedName("data")
    val `data`: List<TagRemote>?
) : BaseResponse() {
    companion object
}

data class TagRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("articles")
    val articles: List<ArticleRemote>?,
    @SerializedName("posts")
    val posts: List<ForumPostRemote>?,
    @SerializedName("comments")
    val comments: List<CommentRemote>?
)