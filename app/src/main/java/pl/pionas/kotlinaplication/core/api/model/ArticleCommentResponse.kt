package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ArticleCommentResponse(
    @SerializedName("data")
    val `data`: List<ArticleCommentRemote>?
) : BaseResponse() {
    companion object
}

data class ArticleCommentRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("article_id")
    val articleId: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("guest_name")
    val guestName: String,
    @SerializedName("guest_mail")
    val guestMail: String,
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
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("article")
    val articleRemote: ArticleRemote,
    @SerializedName("user")
    val user: UserRemote
)