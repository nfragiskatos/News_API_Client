package com.nfragiskatos.news_api_client.presentation.di

import com.nfragiskatos.news_api_client.BuildConfig
import com.nfragiskatos.news_api_client.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.NEWS_API_BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit) : NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }
}