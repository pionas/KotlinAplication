package pl.pionas.kotlinaplication.features.users.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pionas.kotlinaplication.features.users.local.model.UserCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */

@Dao
interface UserDao {

    @Query("SELECT * FROM UserCached")
    suspend fun getUsers(): List<UserCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUsers(vararg users: UserCached)
}