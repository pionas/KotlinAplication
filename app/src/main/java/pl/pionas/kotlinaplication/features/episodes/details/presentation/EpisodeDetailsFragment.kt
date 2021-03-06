package pl.pionas.kotlinaplication.features.episodes.details.presentation

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_episode_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentEpisodeDetailsBinding

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class EpisodeDetailsFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_episode_details
    ) {
    override val viewModel: EpisodeViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.episodeDisplayable = it.getParcelable(EPISODE_DETAILS_KEY)
        }
    }

    override fun initViews(binding: FragmentEpisodeDetailsBinding) {
        super.initViews(binding)
        showEpisodeDetails()
    }

    private fun showEpisodeDetails() {
        viewModel.episodeDisplayable?.let {
            textViewEpisodeName.text = it.name
            textViewEpisodeAirDate.text = it.airDate
            textViewEpisodeCode.text = it.code
        } ?: throw IllegalArgumentException("episodeDetailsKey cannot be null")
    }

}