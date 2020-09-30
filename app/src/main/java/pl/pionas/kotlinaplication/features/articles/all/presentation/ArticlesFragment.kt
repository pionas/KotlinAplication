package pl.pionas.kotlinaplication.features.articles.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentArticleBinding

class ArticlesFragment : BaseFragment<ArticlesViewModel, FragmentArticleBinding>(
    BR.viewModel,
    R.layout.fragment_article
) {

    override val viewModel: ArticlesViewModel by viewModel()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val articlesAdapter: ArticlesAdapter by inject()

    override fun initViews(binding: FragmentArticleBinding) {
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
