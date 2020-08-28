package pl.pionas.kotlinaplication.core.base

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}