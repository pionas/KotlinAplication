package pl.pionas.kotlinaplication.features.articles.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.databinding.ArticleItemBinding
import pl.pionas.kotlinaplication.features.articles.all.presentation.model.ArticleDisplayable

/**
 * Created by Adrian Pionka on 25 sierpień 2020
 * adrian@pionka.com
 */
class ArticlesAdapter(private val articlesViewModel: ArticlesViewModel) :
    BindableAdapter<ArticleDisplayable>,
    BaseAdapter<ArticleDisplayable>() {

    constructor(articlesViewModel: ArticlesViewModel, list: List<ArticleDisplayable>) : this(
        articlesViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding, articlesViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: ArticleDisplayable = items[position]
        (holder as ArticleViewHolder).bind(movie)
    }

    class ArticleViewHolder(
        private val binding: ArticleItemBinding,
        private val articlesViewModel: ArticlesViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: ArticleDisplayable) {
            with(binding) {
                binding.item = article
                articlesViewModel.let { articleViewModel ->
                    root.setOnClickListener {
                        articleViewModel.onArticleClick(article)
                    }
                }
                binding.executePendingBindings()
            }
        }
    }

}