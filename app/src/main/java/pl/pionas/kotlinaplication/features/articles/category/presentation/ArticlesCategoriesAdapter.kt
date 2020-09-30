package pl.pionas.kotlinaplication.features.articles.category.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.BaseAdapter
import pl.pionas.kotlinaplication.databinding.ArticleCategoryItemBinding
import pl.pionas.kotlinaplication.features.articles.category.presentation.model.ArticleCategoryDisplayable

class ArticlesCategoriesAdapter(private val articlesViewModel: ArticlesCategoriesViewModel) :
    BindableAdapter<ArticleCategoryDisplayable>,
    BaseAdapter<ArticleCategoryDisplayable>() {

    constructor(
        articlesViewModel: ArticlesCategoriesViewModel,
        list: List<ArticleCategoryDisplayable>
    ) : this(
        articlesViewModel
    ) {
        super.setItems(list)
    }

    override fun onCreateViewHolderBase(
        parent: ViewGroup,
        viewType: Int
    ): ArticleCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleCategoryItemBinding.inflate(inflater, parent, false)
        return ArticleCategoryViewHolder(binding, articlesViewModel)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: ArticleCategoryDisplayable = items[position]
        (holder as ArticleCategoryViewHolder).bind(movie)
    }

    class ArticleCategoryViewHolder(
        private val binding: ArticleCategoryItemBinding,
        private val articlesCategoriesViewModel: ArticlesCategoriesViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(articleCategory: ArticleCategoryDisplayable) {
            with(binding) {
                binding.item = articleCategory
                articlesCategoriesViewModel.let { articleViewModel ->
                    root.setOnClickListener {
                        articleViewModel.onArticleCategoryClick(articleCategory)
                    }
                }
                binding.executePendingBindings()
            }
        }
    }

}