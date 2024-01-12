package com.bignerdranch.android.tortuganews.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.tortuganews.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)

abstract class ArticleDatabase : RoomDatabase() { //database classes for room always have to be abstract
    abstract fun getArticleDAO(): ArticleDAO

    companion object {
        @Volatile //other threads can immediately see when a thread changes this instance
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) { //if instance is null, we need to start a synchronized block
            //with lock we make sure that no other thread sets the instance to something
        //when we initialize the ArticleDatabase object
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
        }
}
