package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import pl.pionas.kotlinaplication.features.articles.domain.model.Article
import java.util.*

data class ArticleResponse(
    @SerializedName("data")
    val `data`: List<ArticleRemote>?
) : BaseResponse() {
    companion object
}

data class ArticleRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("city")
    val city: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("website")
    val website: String?,
    @SerializedName("article_promoter_id")
    val articlePromoterId: Int?,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("urls")
    val urls: List<String>?,
    @SerializedName("terms")
    val terms: String?,
    @SerializedName("prices")
    val prices: String?,
    @SerializedName("date_start")
    val dateStart: Date?,
    @SerializedName("date_end")
    val dateEnd: Date?,
    @SerializedName("guest_name")
    val guestName: String?,
    @SerializedName("guest_mail")
    val guestMail: String?,
    @SerializedName("user_id")
    val userId: Int?,
    @SerializedName("accepted_user_id")
    val acceptedUserId: Int?,
    @SerializedName("promo")
    val promo: Int?,
    @SerializedName("homepage")
    val homepage: Int?,
    @SerializedName("buybox")
    val buybox: String?,
    @SerializedName("visitor")
    val visitor: String?,
    @SerializedName("status")
    val status: Int,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("base_category_id")
    val baseCategoryId: Int,
    @SerializedName("end_days")
    val endDays: Int,
    @SerializedName("start_days")
    val startDays: Int,
    @SerializedName("image_path")
    val imagePath: String?,
    @SerializedName("articles_categories")
    val articlesCategories: List<ArticleCategoryRemote>?,
    @SerializedName("articles_promoters")
    val articlesPromoters: ArticlePromoterRemote?,
    @SerializedName("user_added")
    val userAdded: UserRemote?,
    @SerializedName("prizes")
    val prizes: List<ArticlePrizeRemote>?,
    @SerializedName("tags")
    val tags: List<TagRemote>?
) {
    constructor(
        id: Int,
        title: String,
        website: String,
        slug: String,
        urls: List<String>?,
        status: Int,
        createdAt: Date,
        endDays: Int,
        startDays: Int
    ) : this(
        id,
        title,
        null,
        null,
        website,
        null,
        slug,
        null,
        null,
        urls,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        status,
        createdAt,
        null,
        1,
        endDays,
        startDays,
        null,
        null,
        null,
        null,
        null,
        null
    )

    companion object

    fun toArticle() = Article(
        id,
        title,
        city,
        image,
        website,
        articlePromoterId,
        slug,
        description,
        content,
        urls,
        terms,
        prices,
        dateStart,
        dateEnd,
        guestName,
        guestMail,
        userId,
        acceptedUserId,
        promo,
        homepage,
        buybox,
        visitor,
        status,
        createdAt,
        updatedAt,
        baseCategoryId,
        endDays,
        startDays,
        imagePath
    )

}