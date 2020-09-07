package pl.pionas.kotlinaplication.features.episodes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.episodes.all.presentation.EpisodesAdapter
import pl.pionas.kotlinaplication.features.episodes.all.presentation.EpisodesFragment
import pl.pionas.kotlinaplication.features.episodes.all.presentation.EpisodesViewModel
import pl.pionas.kotlinaplication.features.episodes.data.repository.EpisodeRepository
import pl.pionas.kotlinaplication.features.episodes.data.repository.EpisodeRepositoryImpl
import pl.pionas.kotlinaplication.features.episodes.details.presentation.EpisodeViewModel
import pl.pionas.kotlinaplication.features.episodes.domain.GetEpisodesUseCase
import pl.pionas.kotlinaplication.features.episodes.navigation.EpisodeNavigator
import pl.pionas.kotlinaplication.features.episodes.navigation.EpisodeNavigatorImpl

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val episodeModule = module {
    // data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // presentation
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
    viewModel { EpisodesViewModel(get(), get(), get()) }
    factory { EpisodesFragment() }
    factory { EpisodesAdapter(get()) }
    viewModel { EpisodeViewModel() }
}