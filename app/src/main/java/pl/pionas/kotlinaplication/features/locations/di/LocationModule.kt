package pl.pionas.kotlinaplication.features.locations.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.locations.all.presentation.LocationsAdapter
import pl.pionas.kotlinaplication.features.locations.all.presentation.LocationsFragment
import pl.pionas.kotlinaplication.features.locations.all.presentation.LocationsViewModel
import pl.pionas.kotlinaplication.features.locations.data.repository.LocationRepository
import pl.pionas.kotlinaplication.features.locations.data.repository.LocationRepositoryImpl
import pl.pionas.kotlinaplication.features.locations.details.presentation.LocationViewModel
import pl.pionas.kotlinaplication.features.locations.domain.GetLocationsUseCase
import pl.pionas.kotlinaplication.features.locations.navigation.LocationNavigator
import pl.pionas.kotlinaplication.features.locations.navigation.LocationNavigatorImpl

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val locationModule = module {
    // data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetLocationsUseCase(get()) }

    // presentation
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
    viewModel { LocationsViewModel(get(), get(), get()) }
    factory { LocationsFragment() }
    factory { LocationsAdapter(get()) }
    viewModel { LocationViewModel() }
}