package com.mohali.newsapp_virtusa.db

import androidx.room.TypeConverter
import com.mohali.newsapp_virtusa.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source) = source.name

    @TypeConverter
    fun toSource(name: String) = Source(name, name)
}