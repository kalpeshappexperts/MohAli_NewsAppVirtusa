package com.mohali.newsapp_virtusa.di

import android.content.Context
import androidx.room.Room
import com.mohali.newsapp_virtusa.db.ArticleDatabase
import com.mohali.newsapp_virtusa.util.Constant.Companion.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        com.mohali.newsapp_virtusa.db.ArticleDatabase::class.java,
        NEWS_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideArticleDao(db: com.mohali.newsapp_virtusa.db.ArticleDatabase) = db.getArticleDao()
}