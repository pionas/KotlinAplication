package pl.pionas.kotlinaplication.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
abstract class BaseFragment<T : BaseViewModel, S : ViewDataBinding>(
    private val viewModelId: Int,
    @LayoutRes layoutRes: Int
) :
    Fragment(layoutRes) {
    abstract val viewModel: T
    var binding: S? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.setVariable(viewModelId, viewModel)
            initViews(it)
        }
        initObservers()
        bindViewModelToLifecycle()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    open fun initViews(it: S) {}

    open fun initObservers() {
        observeMessage()
        observeUiState()
    }

    open fun onIdleStatus() {
        // handle idle state
    }

    open fun onPendingState() {
        // handle pending state
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UiState.Idle -> onIdleStatus()
                UiState.Pending -> onPendingState()
            }
        }
    }


}