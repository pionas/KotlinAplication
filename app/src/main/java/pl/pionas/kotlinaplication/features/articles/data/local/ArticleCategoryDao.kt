package pl.pionas.kotlinaplication.features.articles.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.pionas.kotlinaplication.features.articles.data.local.model.ArticleCategoryCached

@Dao
interface ArticleCategoryDao {

    @Query("SELECT * FROM ArticleCategoryCached")
    suspend fun getArticlesCategories(): List<ArticleCategoryCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArticlesCategories(vararg articleCategory: ArticleCategoryCached)
}