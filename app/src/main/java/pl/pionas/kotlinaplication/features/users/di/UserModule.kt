package pl.pionas.kotlinaplication.features.users.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.users.domain.GetAuthUseCase
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginFragment
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginViewModel
import pl.pionas.kotlinaplication.features.users.login.repository.AuthRepository
import pl.pionas.kotlinaplication.features.users.login.repository.AuthRepositoryImpl

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */

val userModule = module {
    // data
    factory<AuthRepository> { AuthRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetAuthUseCase(get()) }

    // presentation
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginFragment() }
}