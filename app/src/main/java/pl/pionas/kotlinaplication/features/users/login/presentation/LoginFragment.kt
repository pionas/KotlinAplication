package pl.pionas.kotlinaplication.features.users.login.presentation

import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentLoginBinding
import pl.pionas.kotlinaplication.features.users.AuthState
import pl.pionas.kotlinaplication.features.users.presentation.model.UserDisplayable

class LoginFragment :
    BaseFragment<LoginViewModel, FragmentLoginBinding>(BR.viewModel, R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModel()
    override fun initViews(binding: FragmentLoginBinding) {
        super.initViews(binding)
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

    private fun observeLogin() {
        viewModel.user.observe(this) {
            setUser(it)
        }
    }

    private fun observeFormState() {
        viewModel.loginFormState.observe(this) {
            buttonLogin.isEnabled = it.authState === null
            when (it.authState) {
                AuthState.UsernameIsEmpty -> editTextUsername.error =
                    getString(R.string.username_cant_be_empty)
                AuthState.PasswordIsTooShort -> editTextPassword.error =
                    getString(R.string.password_cant_be_too_short)
            }
        }
    }

    fun login() {
        viewModel.auth(editTextUsername.text.toString(), editTextPassword.text.toString())
    }

    private fun setUser(userDisplayable: UserDisplayable?) {

    }

}
