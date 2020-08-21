package pl.pionas.kotlinaplication.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.pionas.kotlinaplication.features.episodes.data.local.EpisodeDao
import pl.pionas.kotlinaplication.features.episodes.data.local.model.EpisodeCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao

}