package pl.pionas.kotlinaplication.features.characters.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.characters.all.presentation.CharactersAdapter
import pl.pionas.kotlinaplication.features.characters.all.presentation.CharactersFragment
import pl.pionas.kotlinaplication.features.characters.all.presentation.CharactersViewModel
import pl.pionas.kotlinaplication.features.characters.data.repository.CharacterRepository
import pl.pionas.kotlinaplication.features.characters.data.repository.CharacterRepositoryImpl
import pl.pionas.kotlinaplication.features.characters.details.presentation.CharacterViewModel
import pl.pionas.kotlinaplication.features.characters.domain.GetCharactersUseCase
import pl.pionas.kotlinaplication.features.characters.navigation.CharacterNavigator
import pl.pionas.kotlinaplication.features.episodes.navigation.CharacterNavigatorImpl

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val characterModule = module {
    // data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetCharactersUseCase(get()) }

    // presentation
    single<CharacterNavigator> { CharacterNavigatorImpl(get()) }
    viewModel { CharactersViewModel(get(), get(), get()) }
    factory { CharactersFragment() }
    factory { CharactersAdapter(get()) }
    viewModel { CharacterViewModel() }
}