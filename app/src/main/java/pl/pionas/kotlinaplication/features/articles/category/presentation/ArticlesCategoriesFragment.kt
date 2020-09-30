package pl.pionas.kotlinaplication.features.articles.category.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_articles_categories.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentArticlesCategoriesBinding
import pl.pionas.kotlinaplication.features.articles.category.presentation.ArticlesCategoriesAdapter

class ArticlesCategoriesFragment : BaseFragment<ArticlesCategoriesViewModel, FragmentArticlesCategoriesBinding>(
    BR.viewModel,
    R.layout.fragment_articles_categories
) {
    override val viewModel: ArticlesCategoriesViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val articlesAdapter: ArticlesCategoriesAdapter by inject()

    override fun initViews(binding: FragmentArticlesCategoriesBinding) {
        super.initViews(binding)
        initRecycler()
    }

    private fun initRecycler() {
        with(recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = articlesAdapter
        }
    }

    override fun onDestroyView() {
        binding?.recyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }


}