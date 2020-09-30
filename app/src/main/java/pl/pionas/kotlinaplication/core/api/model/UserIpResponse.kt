package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class UserIpResponse(
    @SerializedName("data")
    val `data`: List<UserIpRemote>?
) : BaseResponse() {
    companion object
}

data class UserIpRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("visitor")
    val visitor: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?
)