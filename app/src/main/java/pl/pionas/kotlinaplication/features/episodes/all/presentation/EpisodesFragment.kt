package pl.pionas.kotlinaplication.features.episodes.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentEpisodeBinding

class EpisodesFragment :
    BaseFragment<EpisodesViewModel, FragmentEpisodeBinding>(
        BR.viewModel,
        R.layout.fragment_episode
    ) {

    override val viewModel: EpisodesViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val episodeAdapter: EpisodesAdapter by inject()

    override fun initViews(binding: FragmentEpisodeBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentEpisodeBinding) {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = episodeAdapter
        }
    }

    override fun onDestroyView() {
        binding?.recyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

}
