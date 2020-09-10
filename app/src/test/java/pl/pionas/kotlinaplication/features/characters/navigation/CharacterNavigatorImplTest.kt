package pl.pionas.kotlinaplication.features.characters.navigation

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable
import pl.pionas.kotlinaplication.features.episodes.navigation.CharacterNavigatorImpl
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
internal class CharacterNavigatorImplTest {
    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and character model as arguments`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        // when
        characterNavigator.openCharacterDetailsScreen(character)

        // then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_characters_screen_to_character_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        // when
        characterNavigator.goBack()

        // then
        verify {
            fragmentNavigator.goBack()
        }
    }

}