package pl.pionas.kotlinaplication.features.characters.navigation

import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}