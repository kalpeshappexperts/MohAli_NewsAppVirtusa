package com.mohali.newsapp_virtusa.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohali.newsapp_virtusa.model.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(com.mohali.newsapp_virtusa.db.Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): com.mohali.newsapp_virtusa.db.ArticleDao
}