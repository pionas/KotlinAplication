package pl.pionas.kotlinaplication.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import pl.pionas.kotlinaplication.core.exception.ErrorMapper

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
open class BaseViewModel(private val errorMapper: ErrorMapper? = null) : ViewModel(),
    DefaultLifecycleObserver {
    private val _message by lazy { LiveEvent<String>() }

    val message: LiveEvent<String> = _message

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }

    val uiState: LiveData<UiState> = _uiState

    protected fun showMessage(message: String) {
        _message.value = message
    }

    protected fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UiState.Pending
    }

    protected fun handleFailure(throwable: Throwable) {
        errorMapper
            ?.map(throwable)
            ?.let { showMessage(it) }
    }
}