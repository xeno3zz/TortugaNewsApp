package com.bignerdranch.android.tortuganews.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.tortuganews.R
import com.bignerdranch.android.tortuganews.databinding.ItemArticlePreviewBinding
import com.bignerdranch.android.tortuganews.models.Article
import com.bumptech.glide.Glide
import kotlinx.coroutines.NonCancellable.parent

lateinit var binding: ItemArticlePreviewBinding
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {


    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallback = object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
       /* (
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )*/
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
//        with(holder){
//            Glide.with(this.itemView).load(article.ur)
//        }
        with(holder){
            this.itemView.apply {
                Glide.with(this).load(article.urlToImage).into(binding.ivArticleImage)
                binding.tvSource.text = article.source.name
                binding.tvTitle.text = article.title
                binding.tvDescription.text = article.description
                binding.tvPublishedAt.text = article.publishedAt
                setOnItemClickListener{
                    onItemClickListener?.let { it(article) } //incase onItemClickListener != 0 we call the function with current article
                }
            }

        }
//        holder.itemView.apply {
//            //so we can immediately reference our views directly
//            //to load the image from article to imageView - Glide
//            Glide.with(this).load(article.urlToImage).into(binding.ivArticleImage)
//            binding.tvSource.text = article.source.name
//            binding.tvTitle.text = article.title
//            binding.tvDescription.text = article.description
//            binding.tvPublishedAt.text = article.publishedAt
//            setOnItemClickListener{
//                onItemClickListener?.let { it(article) } //incase onItemClickListener != 0 we call the function with current article
//            }
//        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}