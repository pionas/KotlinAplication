package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

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
    val website: String,
    @SerializedName("article_promoter_id")
    val articlePromoterId: Int?,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("urls")
    val urls: List<String>,
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
    val promo: String?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("buybox")
    val buybox: String?,
    @SerializedName("visitor")
    val visitor: String,
    @SerializedName("status")
    val status: String,
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
)
