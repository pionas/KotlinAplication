package pl.pionas.kotlinaplication.features.users.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pionas.kotlinaplication.features.users.data.local.model.UserCached

/**
 * Created by Adrian Pionka on 10 wrzesień 2020
 * adrian@pionka.com
 */

@Dao
interface UserDao {

    @Query("SELECT * FROM UserCached")
    suspend fun getUsers(): List<UserCached>

    @Query("SELECT * FROM UserCached WHERE name = :name")
    suspend fun getUser(name: String): UserCached

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUsers(vararg user: UserCached)
}