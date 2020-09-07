package pl.pionas.kotlinaplication.features.episodes.navigation

import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.pionas.kotlinaplication.mock.mock

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
internal class EpisodeNavigatorImplTest {
    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and episode model as arguments`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        // when
        episodeNavigator.openEpisodeDetailsScreen(episode)

        // then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_episodes_screen_to_episode_details_screen, capture(slot)
            )
        }
        slot.captured.second shouldBe episode
    }

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        // given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        // when
        episodeNavigator.goBack()

        // then
        verify {
            fragmentNavigator.goBack()
        }
    }

}