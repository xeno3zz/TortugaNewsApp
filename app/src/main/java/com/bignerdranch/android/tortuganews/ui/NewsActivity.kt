package com.bignerdranch.android.tortuganews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bignerdranch.android.tortuganews.R
import com.bignerdranch.android.tortuganews.db.ArticleDatabase
import com.bignerdranch.android.tortuganews.repository.NewsRepository

import com.google.android.material.bottomnavigation.BottomNavigationView


class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)


        val newsNavHostFragment = findNavController(R.id.newsNavHostFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(newsNavHostFragment)


//        val newsNavHostFragment = findNavController(viewId = bottomNavigationView.id)
//        bottomNavigationView.setupWithNavController(newsNavHostFragment)
    }
}