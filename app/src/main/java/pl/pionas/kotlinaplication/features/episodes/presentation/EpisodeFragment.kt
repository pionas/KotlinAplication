package pl.pionas.kotlinaplication.features.episodes.presentation

import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        // initialize all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleStatus() {
        super.onIdleStatus()
        // handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {

        }
    }

}
