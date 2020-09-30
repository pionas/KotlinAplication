package pl.pionas.kotlinaplication.core.api.model

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("links")
    val links: Links? = null

    @SerializedName("meta")
    val meta: Meta? = null
}

data class Links(
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("prev")
    val prev: String?,
    @SerializedName("next")
    val next: String?
)

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