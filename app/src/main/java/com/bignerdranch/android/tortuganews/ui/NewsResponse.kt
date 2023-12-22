package com.bignerdranch.android.tortuganews.ui

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)