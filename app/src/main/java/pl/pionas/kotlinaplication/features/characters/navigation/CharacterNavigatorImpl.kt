package pl.pionas.kotlinaplication.features.episodes.navigation

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable
import pl.pionas.kotlinaplication.features.characters.details.presentation.CharacterDetailsFragment
import pl.pionas.kotlinaplication.features.characters.navigation.CharacterNavigator

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {
    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}