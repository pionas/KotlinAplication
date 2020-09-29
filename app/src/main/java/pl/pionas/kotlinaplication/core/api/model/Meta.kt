package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("from")
    val from: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("path")
    val path: String,
    @SerializedName("per_page")
    val perPage: String,
    @SerializedName("to")
    val to: Int,
    @SerializedName("total")
    val total: Int
)