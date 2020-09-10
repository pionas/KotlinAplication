package pl.pionas.kotlinaplication.core.adapter

/**
 * Created by Adrian Pionka on 07 wrzesień 2020
 * adrian@pionka.com
 */
interface BindableAdapter<T> {
    fun setItems(items: List<T>)
}