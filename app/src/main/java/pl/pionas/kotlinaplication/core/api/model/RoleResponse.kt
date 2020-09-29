package pl.pionas.kotlinaplication.core.api.model


import com.google.gson.annotations.SerializedName

data class RoleResponse(
    @SerializedName("data")
    val `data`: List<RoleRemote>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)