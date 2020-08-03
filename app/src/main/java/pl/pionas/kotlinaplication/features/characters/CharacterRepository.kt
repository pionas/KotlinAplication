package pl.pionas.kotlinaplication.features.characters

/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}