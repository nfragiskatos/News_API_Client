package com.nfragiskatos.news_api_client.data.db

import androidx.room.TypeConverter
import com.nfragiskatos.news_api_client.data.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}