package com.bignerdranch.android.tortuganews.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.tortuganews.R
import com.bignerdranch.android.tortuganews.adapter.NewsAdapter
import com.bignerdranch.android.tortuganews.databinding.FragmentSavedNewsBinding
import com.bignerdranch.android.tortuganews.ui.NewsActivity
import com.bignerdranch.android.tortuganews.ui.NewsViewModel

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news){

    lateinit var viewModel: NewsViewModel
    val TAG = "SavedNewsFragment"
    lateinit var newsAdapter: NewsAdapter
    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedNewsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                //resource id of the action we want to perform
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )
        }
    }
    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
