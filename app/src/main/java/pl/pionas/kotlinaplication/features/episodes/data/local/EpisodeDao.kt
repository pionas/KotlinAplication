package pl.pionas.kotlinaplication.features.episodes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pionas.kotlinaplication.features.episodes.data.local.model.EpisodeCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

@Dao
interface EpisodeDao {


    @Query("SELECT * FROM EpisodeCached")
    suspend fun getEpisodes(): List<EpisodeCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episode: EpisodeCached)
}