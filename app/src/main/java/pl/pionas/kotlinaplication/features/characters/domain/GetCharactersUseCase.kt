package pl.pionas.kotlinaplication.features.characters.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.characters.data.repository.CharacterRepository
import pl.pionas.kotlinaplication.features.characters.domain.model.Character


/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}