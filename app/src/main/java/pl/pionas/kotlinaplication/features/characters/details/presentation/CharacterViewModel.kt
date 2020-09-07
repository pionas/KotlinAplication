package pl.pionas.kotlinaplication.features.characters.details.presentation

import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class CharacterViewModel : BaseViewModel() {
    var characterDisplayable: CharacterDisplayable? = null
}