package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class UserThankResponse(
    @SerializedName("data")
    val `data`: List<UserThankRemote>?
) : BaseResponse() {
    companion object
}

data class UserThankRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_thanking_id")
    val userThankingId: Int,
    @SerializedName("content")
    val content: String,
    @SerializedName("visitor")
    val visitor: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("user_thank")
    val userThank: UserRemote,
    @SerializedName("user")
    val user: UserRemote
)