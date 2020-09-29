package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ArticleRelPrizeRemote(
    @SerializedName("article_id")
    val articleId: Int,
    @SerializedName("prize_id")
    val prizeId: Int,
    @SerializedName("article_prize")
    val articlePrize: ArticlePrizeRemote,
    @SerializedName("article")
    val article: ArticleRemote
)