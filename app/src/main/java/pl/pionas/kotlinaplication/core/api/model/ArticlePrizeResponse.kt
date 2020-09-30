package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ArticlePrizeResponse(
    @SerializedName("data")
    val `data`: List<ArticlePrizeRemote>?
) : BaseResponse() {
    companion object
}

data class ArticlePrizeRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)