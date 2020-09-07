package pl.pionas.kotlinaplication.features.characters.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.BR
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.databinding.FragmentCharacterBinding

class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharacterBinding>(
    BR.viewModel,
    R.layout.fragment_character
) {

    override val viewModel: CharactersViewModel by viewModel()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()
    private val charactersAdapter: CharactersAdapter by inject()

    override fun initViews(binding: FragmentCharacterBinding) {
        super.initViews(binding)
        initRecycler()
    }

    private fun initRecycler() {
        with(recyclerView) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = charactersAdapter
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
