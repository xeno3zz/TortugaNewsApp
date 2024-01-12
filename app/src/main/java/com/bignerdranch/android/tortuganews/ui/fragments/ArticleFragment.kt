package com.bignerdranch.android.tortuganews.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.tortuganews.R
import com.bignerdranch.android.tortuganews.databinding.FragmentArticleBinding
import com.bignerdranch.android.tortuganews.ui.NewsActivity
import com.bignerdranch.android.tortuganews.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        //now we receive the article passed from our other fragments
        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient() //makes sure that the page will always load
            //-inside of this webView and don't load in the standard browser of the phone
            article.url?.let { loadUrl(it) }
        }

    }
}