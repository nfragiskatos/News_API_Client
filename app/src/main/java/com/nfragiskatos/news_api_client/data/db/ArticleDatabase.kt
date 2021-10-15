package com.nfragiskatos.news_api_client.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nfragiskatos.news_api_client.data.model.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao() : ArticleDao
}