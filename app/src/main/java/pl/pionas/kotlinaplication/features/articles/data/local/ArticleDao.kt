package pl.pionas.kotlinaplication.features.articles.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCached

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
@Dao
interface ArticleDao {

    @Query("SELECT * FROM ArticleCached")
    suspend fun getArticles(): List<ArticleCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArticles(vararg article: ArticleCached)
}