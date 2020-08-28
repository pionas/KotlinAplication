package pl.pionas.kotlinaplication.features.episodes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.features.episodes.presentation.model.EpisodeDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class EpisodeAdapter() : BaseAdapter<EpisodeDisplayable>() {

    constructor(list: List<EpisodeDisplayable>) : this() {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EpisodeViewHolder(inflater, parent)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: EpisodeDisplayable = items[position]
        (holder as EpisodeViewHolder).bind(movie)
    }

    class EpisodeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.episode_item, parent, false)) {
        private var mEpisodeView: TextView? = null


        init {
            mEpisodeView = itemView.findViewById(R.id.episode_name)
        }

        fun bind(episode: EpisodeDisplayable) {
            mEpisodeView?.text = episode.name
        }

    }

}