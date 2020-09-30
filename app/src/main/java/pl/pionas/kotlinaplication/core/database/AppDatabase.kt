package pl.pionas.kotlinaplication.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.pionas.kotlinaplication.features.articles.data.local.ArticleDao
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCached
import pl.pionas.kotlinaplication.features.users.data.local.UserDao
import pl.pionas.kotlinaplication.features.users.data.local.model.UserCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Database(
    entities = [ArticleCached::class, UserCached::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(ListConverter::class, DateConverter::class, HashMapConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun userDao(): UserDao

}