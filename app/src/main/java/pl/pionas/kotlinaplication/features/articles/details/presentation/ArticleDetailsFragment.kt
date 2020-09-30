package pl.pionas.kotlinaplication.features.articles.details.presentation

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_article_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentArticleDetailsBinding

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class ArticleDetailsFragment :
    BaseFragment<ArticleViewModel, FragmentArticleDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_article_details
    ) {
    override val viewModel: ArticleViewModel by viewModel()

    companion object {
        const val ARTICLE_DETAILS_KEY = "articleDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.articleDisplayable = it.getParcelable(ARTICLE_DETAILS_KEY)
        }
    }

    override fun initViews(binding: FragmentArticleDetailsBinding) {
        super.initViews(binding)
        showArticleDetails()
    }

    private fun showArticleDetails() {
        viewModel.articleDisplayable?.let {
            textViewArticleName.text = it.title
            textViewArticleDescription.text = it.description
            textViewArticleContent.text = it.content
        } ?: throw IllegalArgumentException("articleDetailsKey cannot be null")
    }

}