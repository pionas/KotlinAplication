package pl.pionas.kotlinaplication.features.locations.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.locations.data.repository.LocationRepository
import pl.pionas.kotlinaplication.features.locations.data.repository.LocationRepositoryImpl
import pl.pionas.kotlinaplication.features.locations.domain.GetLocationsUseCase
import pl.pionas.kotlinaplication.features.locations.presentation.LocationAdapter
import pl.pionas.kotlinaplication.features.locations.presentation.LocationFragment
import pl.pionas.kotlinaplication.features.locations.presentation.LocationViewModel

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
    viewModel { LocationViewModel(get(), get()) }
    factory { LocationFragment() }
    factory { LocationAdapter() }
}