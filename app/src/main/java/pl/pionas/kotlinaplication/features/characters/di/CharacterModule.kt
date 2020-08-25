package pl.pionas.kotlinaplication.features.characters.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.pionas.kotlinaplication.features.characters.data.repository.CharacterRepository
import pl.pionas.kotlinaplication.features.characters.data.repository.CharacterRepositoryImpl
import pl.pionas.kotlinaplication.features.characters.domain.GetCharactersUseCase
import pl.pionas.kotlinaplication.features.characters.presentation.CharacterAdapter
import pl.pionas.kotlinaplication.features.characters.presentation.CharacterFragment
import pl.pionas.kotlinaplication.features.characters.presentation.CharacterViewModel

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */

val characterModule = module {
    // data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetCharactersUseCase(get()) }

    // presentation
    viewModel { CharacterViewModel(get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
}