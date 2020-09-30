package pl.pionas.kotlinaplication.features.articles.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.pionas.kotlinaplication.features.articles.domain.model.Article
import java.util.*

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Entity
class ArticleCached(
    @PrimaryKey
    val id: Int,
    val title: String,
    val city: String?,
    val image: String?,
    val website: String?,
    val articlePromoterId: Int?,
    val slug: String,
    val description: String?,
    val content: String?,
    val urls: List<String>?,
    val terms: String?,
    val prices: String?,
    val dateStart: Date?,
    val dateEnd: Date?,
    val guestName: String?,
    val guestMail: String?,
    val userId: Int?,
    val acceptedUserId: Int?,
    val promo: Int?,
    val homepage: Int?,
    val buybox: String?,
    val visitor: String?,
    val status: Int,
    val createdAt: Date,
    val updatedAt: Date?,
    val baseCategoryId: Int,
    val endDays: Int,
    val startDays: Int,
    val imagePath: String?,
//    val articlesCategories: List<ArticleCategoryRemote>?,
//    val articlesPromoters: ArticlePromoterRemote?,
//    val userAdded: UserRemote?,
//    val prizes: List<ArticlePrizeRemote>?,
//    val tags: List<TagRemote>?
) {
    constructor(article: Article) : this(
        id = article.id,
        title = article.title,
        city = article.city,
        image = article.image,
        website = article.website,
        articlePromoterId = article.articlePromoterId,
        slug = article.slug,
        description = article.description,
        content = article.content,
        urls = article.urls,
        terms = article.terms,
        prices = article.prices,
        dateStart = article.dateStart,
        dateEnd = article.dateEnd,
        guestName = article.guestName,
        guestMail = article.guestMail,
        userId = article.userId,
        acceptedUserId = article.acceptedUserId,
        promo = article.promo,
        homepage = article.homepage,
        buybox = article.buybox,
        visitor = article.visitor,
        status = article.status,
        createdAt = article.createdAt,
        updatedAt = article.updatedAt,
        baseCategoryId = article.baseCategoryId,
        endDays = article.endDays,
        startDays = article.startDays,
        imagePath = article.imagePath
    )

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
        null
    )

    companion object

    fun toArticle() = Article(
        id = id,
        title = title,
        city = city,
        image = image,
        website = website,
        articlePromoterId = articlePromoterId,
        slug = slug,
        description = description,
        content = content,
        urls = urls,
        terms = terms,
        prices = prices,
        dateStart = dateStart,
        dateEnd = dateEnd,
        guestName = guestName,
        guestMail = guestMail,
        userId = userId,
        acceptedUserId = acceptedUserId,
        promo = promo,
        homepage = homepage,
        buybox = buybox,
        visitor = visitor,
        status = status,
        createdAt = createdAt,
        updatedAt = updatedAt,
        baseCategoryId = baseCategoryId,
        endDays = endDays,
        startDays = startDays,
        imagePath = imagePath
    )
}