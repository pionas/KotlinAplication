package pl.pionas.kotlinaplication.features.locations.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pionas.kotlinaplication.features.locations.data.local.model.LocationCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Dao
interface LocationDao {

    @Query("SELECT * FROM LocationCached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg location: LocationCached)
}