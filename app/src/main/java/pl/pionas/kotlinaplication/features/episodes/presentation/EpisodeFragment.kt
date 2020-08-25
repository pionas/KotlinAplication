package pl.pionas.kotlinaplication.features.episodes.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
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
            setEpisodes(it)
        }
    }

    private fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        adapter.setItems(episodes)
    }

}
