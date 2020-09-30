package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleRelForumPostResponse(
    @SerializedName("data")
    val `data`: List<ArticleRelForumPostRemote>?
) : BaseResponse() {
    companion object
}

data class ArticleRelForumPostRemote(
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("post_id")
    val postId: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,
    @SerializedName("forum_post")
    val forumPost: ForumPostRemote,
    @SerializedName("article")
    val article: ArticleRemote
)