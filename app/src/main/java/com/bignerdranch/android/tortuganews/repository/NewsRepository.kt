package com.bignerdranch.android.tortuganews.repository

import com.bignerdranch.android.tortuganews.api.RetrofitInstance
import com.bignerdranch.android.tortuganews.db.ArticleDatabase
import java.util.Locale.IsoCountryCode

class NewsRepository(
    val db: ArticleDatabase //used to get the data from database
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}