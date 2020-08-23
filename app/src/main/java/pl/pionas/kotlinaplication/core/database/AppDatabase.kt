package pl.pionas.kotlinaplication.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.pionas.kotlinaplication.features.characters.data.local.CharacterDao
import pl.pionas.kotlinaplication.features.characters.data.local.model.CharacterCached
import pl.pionas.kotlinaplication.features.episodes.data.local.EpisodeDao
import pl.pionas.kotlinaplication.features.episodes.data.local.model.EpisodeCached
import pl.pionas.kotlinaplication.features.locations.data.local.LocationDao
import pl.pionas.kotlinaplication.features.locations.data.local.model.LocationCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Database(
    entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class],
    version = 3
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao

}