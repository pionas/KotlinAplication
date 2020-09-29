package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class UserFieldOptionRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("field_id")
    val fieldId: Int,
    @SerializedName("label")
    val label: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("order")
    val order: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date?,
    @SerializedName("user_field")
    val userField: UserFieldRemote
)