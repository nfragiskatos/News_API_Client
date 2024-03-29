package com.nfragiskatos.news_api_client.data.db

import androidx.room.*
import com.nfragiskatos.news_api_client.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles() : Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}