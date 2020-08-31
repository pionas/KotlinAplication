package pl.pionas.kotlinaplication.features.users.domain.model

/**
 * Created by Adrian Pionka on 27 lipiec 2020
 * adrian@pionka.com
 */
data class User(
    val id: Int?,
    val name: String?,
    val username: String,
    val password: String?,
    val email: String?
) {
    constructor(username: String, password: String) : this(null, null, username, password, null)

    companion object
}