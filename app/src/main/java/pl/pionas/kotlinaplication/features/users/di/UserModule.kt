package pl.pionas.kotlinaplication.features.users.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepositoryImpl
import pl.pionas.kotlinaplication.features.users.domain.AuthUseCase
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginFragment
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginViewModel

/**
 * Created by Adrian Pionka on 31 sierpień 2020
 * adrian@pionka.com
 */

val userModule = module {
    // data
    factory<UserRepository> { UserRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { AuthUseCase(get()) }

    // presentation
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginFragment() }
}