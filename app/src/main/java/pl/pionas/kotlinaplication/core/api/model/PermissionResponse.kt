package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class PermissionResponse(
    @SerializedName("data")
    val `data`: List<PermissionRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)