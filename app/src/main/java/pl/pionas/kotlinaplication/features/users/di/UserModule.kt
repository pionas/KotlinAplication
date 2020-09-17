package pl.pionas.kotlinaplication.features.users.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.users.all.presentation.UsersAdapter
import pl.pionas.kotlinaplication.features.users.all.presentation.UsersFragment
import pl.pionas.kotlinaplication.features.users.all.presentation.UsersViewModel
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepository
import pl.pionas.kotlinaplication.features.users.data.repository.UserRepositoryImpl
import pl.pionas.kotlinaplication.features.users.details.presentation.UserViewModel
import pl.pionas.kotlinaplication.features.users.domain.AuthUseCase
import pl.pionas.kotlinaplication.features.users.domain.GetUsersUseCase
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginFragment
import pl.pionas.kotlinaplication.features.users.login.presentation.LoginViewModel
import pl.pionas.kotlinaplication.features.users.navigation.UserNavigator
import pl.pionas.kotlinaplication.features.users.navigation.UserNavigatorImpl

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val userModule = module {
    // data
    factory<UserRepository> { UserRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetUsersUseCase(get()) }
    factory { AuthUseCase(get()) }

    // presentation
    factory<UserNavigator> { UserNavigatorImpl(get()) }
    viewModel { UsersViewModel(get(), get(), get()) }
    factory { UsersFragment() }
    factory { UsersAdapter(get()) }
    viewModel { UserViewModel() }
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginFragment() }
}