package pl.pionas.kotlinaplication.core.exception

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
sealed class ServerException(message: String?) : Throwable(message) {
    class Internal(message: String?) : ServerException(message)
    class BadRequest(message: String?) : ServerException(message)
    class Unknow(message: String?) : ServerException(message)
}