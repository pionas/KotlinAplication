package pl.pionas.kotlinaplication.features.characters.data.repository

import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.features.characters.data.local.CharacterDao
import pl.pionas.kotlinaplication.features.characters.data.local.model.CharacterCached
import pl.pionas.kotlinaplication.features.characters.domain.model.Character

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }
}