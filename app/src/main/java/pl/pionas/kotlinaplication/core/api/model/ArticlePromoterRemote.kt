package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class ArticlePromoterRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("nip")
    val nip: String,
    @SerializedName("regon")
    val regon: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("mail")
    val mail: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)