package pl.pionas.kotlinaplication.features.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.pionas.kotlinaplication.core.base.BaseViewModel
import pl.pionas.kotlinaplication.features.episodes.domain.GetEpisodesUseCase
import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode
import pl.pionas.kotlinaplication.features.episodes.presentation.model.EpisodeDisplayable

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : BaseViewModel() {
    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also {
                getEpisodes(it)
            }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure {
                handleFailure(it)
            }
        }
    }
}