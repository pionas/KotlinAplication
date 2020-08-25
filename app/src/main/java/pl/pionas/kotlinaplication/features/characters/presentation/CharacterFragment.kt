package pl.pionas.kotlinaplication.features.characters.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.base.BaseFragment
import pl.pionas.kotlinaplication.features.characters.presentation.model.CharacterDisplayable

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        // initialize all view-related classes
        initRecycler()
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleStatus() {
        super.onIdleStatus()
        // handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            setCharacters(it)
        }
    }

    private fun setCharacters(characters: List<CharacterDisplayable>) {
        adapter.setItems(characters)
    }

}
