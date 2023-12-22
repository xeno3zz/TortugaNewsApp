package com.bignerdranch.android.tortuganews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bignerdranch.android.tortuganews.R

import com.google.android.material.bottomnavigation.BottomNavigationView


class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val newsNavHostFragment = findNavController(R.id.newsNavHostFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(newsNavHostFragment)
//        val newsNavHostFragment = findNavController(viewId = bottomNavigationView.id)
//        bottomNavigationView.setupWithNavController(newsNavHostFragment)
    }
}