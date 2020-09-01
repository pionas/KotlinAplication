package pl.pionas.kotlinaplication.features.episodes.navigation

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.pionas.kotlinaplication.features.episodes.details.presentation.EpisodeDetailsFragment

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {
    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}