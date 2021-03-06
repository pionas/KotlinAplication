package pl.pionas.kotlinaplication.mock

import org.jetbrains.annotations.TestOnly
import pl.pionas.kotlinaplication.core.api.model.*
import pl.pionas.kotlinaplication.features.characters.all.presentation.model.CharacterDisplayable
import pl.pionas.kotlinaplication.features.characters.data.local.model.CharacterCached
import pl.pionas.kotlinaplication.features.characters.domain.model.Character
import pl.pionas.kotlinaplication.features.characters.domain.model.Origin
import pl.pionas.kotlinaplication.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.pionas.kotlinaplication.features.episodes.data.local.model.EpisodeCached
import pl.pionas.kotlinaplication.features.episodes.domain.model.Episode
import pl.pionas.kotlinaplication.features.locations.all.presentation.model.LocationDisplayable
import pl.pionas.kotlinaplication.features.locations.data.local.model.LocationCached
import pl.pionas.kotlinaplication.features.locations.domain.model.Location
import pl.pionas.kotlinaplication.features.users.all.presentation.model.UserDisplayable
import pl.pionas.kotlinaplication.features.users.data.local.model.UserCached
import pl.pionas.kotlinaplication.features.users.domain.model.User

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

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 1,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

fun LocationRemote.Companion.mock() = LocationRemote(
    name = "location name",
    url = "location url"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    name = "location name",
    url = "location url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    name = "location name",
    url = "location url"
)

@TestOnly
fun LocationDisplayable.Companion.mock() = LocationDisplayable(
    name = "location name",
    url = "location url"
)

fun Origin.Companion.mock() = Origin(
    name = "origin name",
    url = "orogin url"
)

fun OriginRemote.Companion.mock() = OriginRemote(
    name = "origin name",
    url = "orogin url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = OriginRemote.mock(),
    location = LocationRemote.mock(),
    image = "character image",
    episode = emptyList(),
    url = "character url",
    created = "example date"
)

fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = Origin.mock(),
    location = LocationRemote.mock().toLocation(),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = Origin.mock(),
    location = LocationRemote.mock().toLocation(),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

@TestOnly
fun CharacterDisplayable.Companion.mock() = CharacterDisplayable(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = Origin.mock(),
    location = LocationRemote.mock().toLocation(),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

@TestOnly
fun UserRemote.Companion.mock() = UserRemote(
    id = 1,
    name = "user name",
    avatar = "user avatar"
)

fun UserResponse.Companion.mock() = UserResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        UserRemote.mock(),
        UserRemote.mock(),
        UserRemote.mock()
    )
)

fun UserCached.Companion.mock() = UserCached(
    id = 1,
    name = "user name",
    avatar = "user avatar"
)

@TestOnly
fun User.Companion.mock() = User(
    id = 1,
    name = "user name",
    avatar = "user avatar"
)

@TestOnly
fun UserDisplayable.Companion.mock() = UserDisplayable(
    id = 1,
    name = "user name",
    avatar = "user avatar"
)