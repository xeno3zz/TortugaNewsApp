package com.bignerdranch.android.tortuganews.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.tortuganews.models.Article

@Dao
interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long //what happens if the article that we want to insert already exists in the db, long is ID that was inserted
    @Query("SELECT * FROM articles") //SQL Query that will select all articles that should return
    fun getAllArticles(): LiveData<List<Article>> //LiveData is a class that helps view components
    //subscribe to changes in database and always be up-do-date
    @Delete
    suspend fun deleteArticle(article: Article)
}