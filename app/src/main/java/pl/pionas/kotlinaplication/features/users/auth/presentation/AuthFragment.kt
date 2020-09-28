package pl.pionas.kotlinaplication.features.users.auth.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentAuthBinding

class AuthFragment :
    BaseFragment<AuthViewModel, FragmentAuthBinding>(BR.viewModel, R.layout.fragment_auth) {

    override val viewModel: AuthViewModel by viewModel()

}
