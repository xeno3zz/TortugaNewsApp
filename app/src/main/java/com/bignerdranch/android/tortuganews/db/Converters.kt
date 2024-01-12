package com.bignerdranch.android.tortuganews.db

import androidx.room.TypeConverter
import com.bignerdranch.android.tortuganews.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name //whenever we get source we convert it to string
    }
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}