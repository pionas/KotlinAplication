package pl.pionas.kotlinaplication.features.users.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.users.domain.GetAuthUseCase
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginFragment
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginViewModel
import pl.pionas.kotlinaplication.features.users.login.repository.LoginRepository
import pl.pionas.kotlinaplication.features.users.login.repository.LoginRepositoryImpl

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */

val userModule = module {
    // data
    factory<LoginRepository> { LoginRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetAuthUseCase(get()) }

    // presentation
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginFragment() }
}