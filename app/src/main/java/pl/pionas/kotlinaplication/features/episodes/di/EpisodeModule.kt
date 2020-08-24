package pl.pionas.kotlinaplication.features.episodes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.episodes.data.repository.EpisodeRepository
import pl.pionas.kotlinaplication.features.episodes.data.repository.EpisodeRepositoryImpl
import pl.pionas.kotlinaplication.features.episodes.domain.GetEpisodesUseCase
import pl.pionas.kotlinaplication.features.episodes.presentation.EpisodeFragment
import pl.pionas.kotlinaplication.features.episodes.presentation.EpisodeViewModel

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val episodeModule = module {
    // data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}