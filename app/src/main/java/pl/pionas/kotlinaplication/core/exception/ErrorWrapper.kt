package pl.pionas.kotlinaplication.core.exception

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}