package pl.pionas.kotlinaplication.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.databinding.EpisodeItemBinding
import pl.pionas.kotlinaplication.features.episodes.all.presentation.model.EpisodeDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class EpisodesAdapter(private val episodesViewModel: EpisodesViewModel) :
    BindableAdapter<EpisodeDisplayable>,
    BaseAdapter<EpisodeDisplayable>() {

    constructor(episodesViewModel: EpisodesViewModel, list: List<EpisodeDisplayable>) : this(
        episodesViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EpisodeItemBinding.inflate(inflater, parent, false)
        return EpisodeViewHolder(binding, episodesViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: EpisodeDisplayable = items[position]
        (holder as EpisodeViewHolder).bind(movie)
    }

    class EpisodeViewHolder(
        private val binding: EpisodeItemBinding,
        private val mEpisodesViewModel: EpisodesViewModel?
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                binding.item = episode
                mEpisodesViewModel?.let { episodeViewModel ->
                    root.setOnClickListener {
                        episodeViewModel.onEpisodeClick(episode)
                    }
                }
                binding.executePendingBindings()
            }
        }

    }

}