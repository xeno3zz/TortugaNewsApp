package com.bignerdranch.android.tortuganews.models

import com.bignerdranch.android.tortuganews.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)