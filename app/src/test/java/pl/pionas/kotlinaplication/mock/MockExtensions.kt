package pl.pionas.kotlinaplication.mock

import org.jetbrains.annotations.TestOnly
import pl.pionas.kotlinaplication.core.api.model.EpisodeRemote
import pl.pionas.kotlinaplication.core.api.model.EpisodesResponse
import pl.pionas.kotlinaplication.core.api.model.ResponseInfo
import pl.pionas.kotlinaplication.features.episodes.data.local.model.EpisodeCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "prev page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example date"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)