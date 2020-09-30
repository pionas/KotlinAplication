package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName

data class ArticleCategoryResponse(
    @SerializedName("data")
    val `data`: List<ArticleCategoryRemote>?
) : BaseResponse() {
    companion object
}

data class ArticleCategoryRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("order")
    val order: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("getparent")
    val getparent: Int
)