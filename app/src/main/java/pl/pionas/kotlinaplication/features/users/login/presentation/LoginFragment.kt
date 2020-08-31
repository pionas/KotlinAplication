package pl.pionas.kotlinaplication.features.users.login.presentation

import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.features.users.presentation.model.UserDisplayable

class LoginFragment : BaseFragment<LoginViewModel>(R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModel()
    override fun initViews() {
        super.initViews()
        buttonLogin.setOnClickListener {
            login()
        }
        editTextUsername.doAfterTextChanged {
            viewModel.validate(editTextUsername.text.toString(), editTextPassword.text.toString())
        }
        editTextPassword.doAfterTextChanged {
            viewModel.validate(editTextUsername.text.toString(), editTextPassword.text.toString())
        }
    }

    override fun initObservers() {
        super.initObservers()
        observeLogin()
        observeFormState()
    }

    override fun onIdleStatus() {
        super.onIdleStatus()
        progressBarLoading.visibility = View.GONE
        relativeLayoutForm.visibility = View.VISIBLE
    }

    override fun onPendingState() {
        super.onPendingState()
        progressBarLoading.visibility = View.VISIBLE
        relativeLayoutForm.visibility = View.GONE
    }

    private fun observeLogin() {
        viewModel.user.observe(this) {
            setUser(it)
        }
    }

    private fun observeFormState() {
        viewModel.loginFormState.observe(this) {
            // disable login button unless both username / password is valid
            buttonLogin.isEnabled = it.isDataValid

            if (it.usernameError != null) {
                editTextUsername.error = getString(it.usernameError)
            }
            if (it.passwordError != null) {
                editTextPassword.error = getString(it.passwordError)
            }
        }
    }

    fun login() {
        viewModel.auth(editTextUsername.text.toString(), editTextPassword.text.toString())
    }

    private fun setUser(userDisplayable: UserDisplayable?) {

    }

}
