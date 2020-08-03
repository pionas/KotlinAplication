package pl.pionas.kotlinaplication.features.episodes.domain

import pl.pionas.kotlinaplication.core.base.UseCase
import pl.pionas.kotlinaplication.features.episodes.EpisodeRepository
import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode

/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}