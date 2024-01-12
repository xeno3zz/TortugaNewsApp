package com.bignerdranch.android.tortuganews.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(
    //the entity annotation shows room that article is a table in database
    tableName = "articles"

)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable{
    override fun hashCode(): Int {
        var result = id.hashCode()
        if(url.isNullOrEmpty()){
            result = 31 * result + url.hashCode()
        }
        return result
    }
}