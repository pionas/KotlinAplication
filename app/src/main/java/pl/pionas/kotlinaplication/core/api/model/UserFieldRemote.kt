package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class UserFieldRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("label")
    val label: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("alias")
    val alias: String?,
    @SerializedName("order")
    val order: String,
    @SerializedName("validators")
    val validators: Any,
    @SerializedName("visible")
    val visible: Boolean,
    @SerializedName("show_privacy")
    val showPrivacy: Boolean,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?
)