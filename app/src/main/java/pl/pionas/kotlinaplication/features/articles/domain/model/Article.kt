package pl.pionas.kotlinaplication.features.articles.domain.model

import java.util.*

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
data class Article(
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
//    val articlesCategories: List<ArticleCategoryDisplayable>?,
//    val articlesPromoters: ArticlePromoterDisplayable?,
//    val userAdded: UserDisplayable?,
//    val prizes: List<ArticlePrizeDisplayable>?,
//    val tags: List<TagDisplayable>?
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
        null
    )

    companion object
}


