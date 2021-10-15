package com.nfragiskatos.news_api_client.presentation.di

import android.app.Application
import androidx.room.Room
import com.nfragiskatos.news_api_client.data.db.ArticleDao
import com.nfragiskatos.news_api_client.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): ArticleDatabase {
        return Room.databaseBuilder(app, ArticleDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(articleDatabase: ArticleDatabase): ArticleDao {
        return articleDatabase.getArticleDao()
    }
}